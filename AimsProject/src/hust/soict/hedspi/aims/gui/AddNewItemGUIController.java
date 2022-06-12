package hust.soict.hedspi.aims.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.gui.res.AIMSResources;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.MediaType;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.test.cellValueFactory.LineNumbersCellFactory_OneIndexed;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.gui.res.*;

public class AddNewItemGUIController implements Initializable {

	@FXML
	private Button newItem_CancelBtn;

	@FXML
	private Label newItem_ContentLabel;

	@FXML
	private TextField newItem_CategoryTf;

	@FXML
	private TextArea newItem_AuthorlistTa;

	@FXML
	private Label newItem_TitleLabel;

	@FXML
	private TextField newItem_IDTf;

	@FXML
	private TextField newItem_CostTf;

	@FXML
	private TextField newItem_TitleTf;

	@FXML
	private TableView<Track> newItem_TrackTableview;

	@FXML
	private Label newItem_DirectorLabel;

	@FXML
	private ChoiceBox<MediaType> newItem_Choicebox;

	@FXML
	private TextArea newItem_ContentTa;

	@FXML
	private TextField newItem_DirectorTf;

	@FXML
	private Label newItem_AuthorListLabel;

	@FXML
	private Label newItem_TrackLabel;

	@FXML
	private Label newItem_ArtistLabel;

	@FXML
	private Label newItem_CategoryLabel;

	@FXML
	private Label newItem_CostLabel;

	@FXML
	private TextField newItem_LengthTf;

	@FXML
	private Button newItem_AddBtn;

	@FXML
	private Label newItem_LengthLabel;

	@FXML
	private Label newItem_IDLabel;

	@FXML
	private VBox newItem_BookVbox;

	@FXML
	private VBox newItem_CDVbox;

	@FXML
	private VBox newItem_DVDVbox;

	@FXML
	private TextField newItem_ArtistTf;

	@FXML
	private Button newItem_AddTrackBtn;

	@FXML
	private Button newItem_RemoveTrackBtn;

	@FXML
	private Button newItem_PlayAllTracks;

	@FXML
	private TableColumn<Track, Integer> newItem_TrackTableview_No;

	@FXML
	private TableColumn<Track, String> newItem_TrackTableview_Title;

	@FXML
	private TableColumn<Track, Integer> newItem_TrackTableview_Length;

	@FXML
	private TextField newItem_TotalLengthTf;

	private int cur_mediaType;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MediaType Book = new MediaType(MediaType.BOOK);
		MediaType CD = new MediaType(MediaType.CD);
		MediaType DVD = new MediaType(MediaType.DVD);

		ObservableList<MediaType> mediaTypes = FXCollections.observableArrayList(Book, CD, DVD);
		newItem_Choicebox.setItems(mediaTypes);
		ChangeListener<MediaType> changeListener = new ChangeListener<MediaType>() {
			@Override
			public void changed(ObservableValue<? extends MediaType> observable, MediaType oldValue,
					MediaType newValue) {
				if (newValue != null) {
					switch (newValue.getMediaID()) {
					case MediaType.BOOK:
						handleAddBookCase();
						break;
					case MediaType.CD:
						handleAddCDCase();
						break;
					case MediaType.DVD:
						handleAddDVDCase();
						break;
					default:
						break;
					}
				}
			}
		};
		
		newItem_Choicebox.getSelectionModel().selectedItemProperty().addListener(changeListener);
		hideUnneededFields();
		newItem_TrackTableview_No.setCellFactory(new LineNumbersCellFactory_OneIndexed<>());
		newItem_TrackTableview_Title.setCellValueFactory(new PropertyValueFactory<Track, String>("title"));
		newItem_TrackTableview_Length.setCellValueFactory(new PropertyValueFactory<Track, Integer>("length"));
		
		
		AIMSResources.request.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				if (!AIMSResources.request.isEmpty()
						&& AIMSResources.request.get(0) == AIMSResources.ADDITEM_REFRESH_TRACK_TABLE_REQUEST) {
					displayTrackListtable();
					displayCDTotalLength();
					AIMSResources.request.clear();
				}
			}
		});

	}

	public void AddBtn() {
		if(!mediaIsValid()) 
			return;
		
		switch (cur_mediaType) {
		case MediaType.BOOK:
			if(!bookisValid()) return;
			addBook();
			break;
		case MediaType.CD:
			if(!cdIsValid()) return;
			addCD();
			break;
		case MediaType.DVD:
			if(!dvdIsValid()) return;
			addDVD();
			break;
		default:
			ApplicationAlert.mediaTypeNotChosenAlert();
			return;
		}

		AIMSResources.request.add(AIMSResources.MENU_REFRESH_SCREEN_REQUEST);
		clearInput();
	}

	public void addBook() {
		Book book = new Book(newItem_IDTf.getText(), newItem_TitleTf.getText(), newItem_CategoryTf.getText(),
				Float.parseFloat(newItem_CostTf.getText()), newItem_AuthorlistTa.getText().split(".,"),
				newItem_ContentTa.getText());
		try {
			AIMS_GUI.AIMS_GUImain.addItem(cur_mediaType, book, null, null);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addCD() {
		CompactDisc cd = new CompactDisc(newItem_IDTf.getText(), newItem_TitleTf.getText(),
				newItem_CategoryTf.getText(), newItem_ArtistTf.getText(), Float.parseFloat(newItem_CostTf.getText()));

		for (Track track : AIMSResources.cur_trackList) {
			cd.addTracks(track);
		}
		try {
			AIMS_GUI.AIMS_GUImain.addItem(cur_mediaType, null, null, cd);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addDVD() {
		DigitalVideoDisc dvd = new DigitalVideoDisc(newItem_IDTf.getText(), newItem_TitleTf.getText(),
				newItem_CategoryTf.getText(), newItem_DirectorTf.getText(),
				Integer.parseInt(newItem_LengthTf.getText()), Float.parseFloat(newItem_CostTf.getText()));
		try {
			AIMS_GUI.AIMS_GUImain.addItem(cur_mediaType, null, dvd, null);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void CancelBtn(ActionEvent actionEvent) {
		AIMSResources.cur_trackList.clear();
		Node source = (Node) actionEvent.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
	
	public void playAllTracksBtn() {
	}

	public void handleAddBookCase() {
		cur_mediaType = MediaType.BOOK;
		revealHiddenFields();
		newItem_CDVbox.setVisible(false);
		newItem_DVDVbox.setVisible(false);
	}

	public void handleAddCDCase() {
		cur_mediaType = MediaType.CD;
		revealHiddenFields();
		newItem_BookVbox.setVisible(false);
		newItem_DVDVbox.setVisible(false);
	}

	public void handleAddDVDCase() {
		cur_mediaType = MediaType.DVD;
		revealHiddenFields();

		newItem_CDVbox.setVisible(false);
		newItem_BookVbox.setVisible(false);
	}

	public void revealHiddenFields() {
		newItem_BookVbox.setVisible(true);
		newItem_CDVbox.setVisible(true);
		newItem_DVDVbox.setVisible(true);
	}

	public void hideUnneededFields() {
		newItem_BookVbox.setVisible(false);
		newItem_CDVbox.setVisible(false);
		newItem_DVDVbox.setVisible(false);
	}

	public void addTrackBtn() throws IOException {
		// Load and Open AddTrack Stage
		Parent addTrackParent = FXMLLoader.load(getClass().getResource("AddTrackGUI.fxml"));
		Scene addTrackScene = new Scene(addTrackParent);
		Stage addTrackStage = new Stage();
		addTrackStage.setScene(addTrackScene);
		addTrackStage.setTitle("Add Track to CD");
		addTrackStage.show();
	}

	public void clearInput() {
		newItem_TitleTf.clear();
		newItem_CategoryTf.clear();
		newItem_IDTf.clear();
		newItem_CostTf.clear();
		newItem_AuthorlistTa.clear();
		newItem_ContentTa.clear();
		newItem_ArtistTf.clear();
		newItem_LengthTf.clear();
		newItem_DirectorTf.clear();
		AIMSResources.cur_trackList.removeAll();
	}

	public void displayTrackListtable() {
		newItem_TrackTableview.setItems(AIMSResources.cur_trackList);
		
//		for(Track track: AIMSResources.cur_trackList) {
//			System.out.println("track " + track.getTitle());
//		}
	}

	public void displayCDTotalLength() {
		int totalLength = 0;
		for (Track track : AIMSResources.cur_trackList) {
			totalLength += track.getLength();
		}
		newItem_TotalLengthTf.setText(String.valueOf(totalLength));
	}

	public void removeTrackBtn() {
		try {
			Parent removeTrackParent = FXMLLoader.load(getClass().getResource("RemoveTrackGUI.fxml"));
			Scene removeTrackScene = new Scene(removeTrackParent);
			Stage removeTrackStage = new Stage();
			removeTrackStage.setScene(removeTrackScene);
			removeTrackStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean bookisValid() {	
		if(!mediaIsValid()) 
			return false;
		if(newItem_AuthorlistTa.getText().isEmpty() || newItem_ContentTa.getText().isEmpty()) {
			ApplicationAlert.allRequiredInformationNotFilledAlert();
			return false;
		}
		return true;
	}
	
	public boolean cdIsValid() {
		if(!mediaIsValid()) 
			return false;
		if(newItem_ArtistTf.getText().isEmpty()) {
			ApplicationAlert.allRequiredInformationNotFilledAlert();
			return false;
		}
		return true;
	}
	
	public boolean dvdIsValid() {
		if(!mediaIsValid()) 
			return false;
		if(newItem_DirectorTf.getText().isEmpty() || newItem_LengthTf.getText().isEmpty()) {
			ApplicationAlert.allRequiredInformationNotFilledAlert();
			return false;
		}
		
		try {
			Integer.parseInt(newItem_LengthTf.getText());
		} catch (NumberFormatException e) {
			ApplicationAlert.invalidLengthAlert();
			return false;
		}
		
		return true;
	}

	public boolean mediaIsValid() {
		if (!minimumInformations_IsFilled()) {
			ApplicationAlert.allRequiredInformationNotFilledAlert();
			return false;
		}
		if (!costIsValid()) {
			ApplicationAlert.invalidCostAlert();
			return false;
		}
		return true;
	}

	public boolean minimumInformations_IsFilled() {
		if (newItem_TitleTf.getText().isEmpty() || newItem_IDTf.getText().isEmpty()
				|| newItem_CategoryTf.getText().isEmpty() || newItem_CostTf.getText().isEmpty()) {
			return false;
		} else
			return true;
	}

	public boolean costIsValid() {
		try {
			Float.parseFloat(newItem_CostTf.getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
