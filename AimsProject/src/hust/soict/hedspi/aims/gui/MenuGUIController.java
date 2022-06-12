package hust.soict.hedspi.aims.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.gui.res.AIMSResources;
import hust.soict.hedspi.aims.gui.res.ApplicationAlert;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.test.cellValueFactory.LineNumbersCellFactory_OneIndexed;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuGUIController implements Initializable {

	@FXML
	private Button menu_AddNewItemBtn;

	@FXML
	private Button menu_PlayMediaBtn;

	@FXML
	private Button menu_CreateOrderBtn;

	@FXML
	private Button menu_LoadSampleOrderBtn;

	@FXML
	private Button menu_DeleteItemBtn;

	@FXML
	private Button menu_rollLuckyBtn;
	
	@FXML
	private Label menu_luckyItemLabel;
	
	@FXML
	private Label menu_orderLabel;

	@FXML
	private TableView<Media> menu_ItemTableview;

	@FXML
	private TableColumn<Media, String> menu_ItemTableview_Category;

	@FXML
	private TableColumn<Media, Integer> menu_ItemTableview_No;

	@FXML
	private TableColumn<Media, String> menu_ItemTableview_Title;

	@FXML
	private TableColumn<Media, Float> menu_ItemTableview_Cost;

	@FXML
	private TableColumn<Media, String> menu_ItemTableview_ID;

	@FXML
	private TextField menu_CostTf;

	@FXML
	private TextField menu_CreatedDateTf;

	@FXML
	private TilePane menu_OrderListTilepane;	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		menu_ItemTableview_Category.setCellValueFactory(new PropertyValueFactory<>("category"));
		menu_ItemTableview_No.setCellFactory(new LineNumbersCellFactory_OneIndexed());
		menu_ItemTableview_Title.setCellValueFactory(new PropertyValueFactory<>("title"));
		menu_ItemTableview_Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
		menu_ItemTableview_ID.setCellValueFactory(new PropertyValueFactory<>("id"));

		AIMSResources.request.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				if (!AIMSResources.request.isEmpty() && AIMSResources.request.get(0) == AIMSResources.MENU_REFRESH_SCREEN_REQUEST) {
					refreshScene();
					AIMSResources.request.clear();
				}	
			}
		});
		
		//Set button events
		menu_PlayMediaBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Stage playMediaStage = new Stage();
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("PlayMediaGUI.fxml"));
					Scene menuScene = new Scene(root);
			    	playMediaStage.setScene(menuScene);
			    	playMediaStage.setTitle("AIMS_menu");
			    	playMediaStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	
		menu_rollLuckyBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Media luckyItem = AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getALuckyItem();
				if(luckyItem != null) {
					menu_luckyItemLabel.setText("Your lucky item is: " + luckyItem.getTitle());
				} else {
					menu_luckyItemLabel.setText("You didn't meet the requirement or it's just pure bad luck ;_;");
				}
			}
		});
	}

	// Button events
	public void createNewOrderBtn() {
		int alertContentID = AIMS_GUI.AIMS_GUImain.createNewOrder();
		switch (alertContentID) {
		case AIMS_GUI.Alert_createNewOrder_successful: {
			ApplicationAlert.newOrderCreatedAlert();
			addButtontoOrderListTilePane();
			break;
		}
		case AIMS_GUI.Alert_createNewOrder_fail:
			ApplicationAlert.orderMaximumReachedAlert();
			break;
		default:
			break;
		}
		refreshScene();
	}

	public void addNewItemBtn() {
		//Clear current track List before 
		AIMSResources.cur_trackList.clear();
		
		for(Track track: AIMSResources.cur_trackList) {
			System.out.print(" [menuGUIController] addNewItemBtn ");
			System.out.println("track " + track.getTitle());
		}
		
		
		if (AIMSResources.orderList.isEmpty()) {
			ApplicationAlert.noChosenOrderAlert();
		} else {
			Stage AddNewItemStage = new Stage();
			Parent AddNewItemParent;
			try {
				AddNewItemParent = FXMLLoader.load(getClass().getResource("AddNewItemGUI.fxml"));
				Scene AddNewItemScene = new Scene(AddNewItemParent);
				AddNewItemStage.setScene(AddNewItemScene);
				AddNewItemStage.setTitle("Add new item");
				AddNewItemStage.initModality(Modality.WINDOW_MODAL);
				AddNewItemStage.initOwner(AIMS_GUI.getMenuStage());
				AddNewItemStage.show();		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteItemBtn() {
		if (AIMSResources.orderList.isEmpty()) {
			ApplicationAlert.noChosenOrderAlert();
		} else {
			Stage DeleteItemStage = new Stage();
			Parent DeleteItemParent;
			try {
				DeleteItemParent = FXMLLoader.load(getClass().getResource("DeleteItemGUI.fxml"));
				Scene DeleteItemScene = new Scene(DeleteItemParent);
				DeleteItemStage.setScene(DeleteItemScene);
				DeleteItemStage.setTitle("DeleteItem");
				DeleteItemStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadSampleOrderBtn() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Sample Order has been loaded!");
		alert.setTitle("Load Sample Order");
		alert.setHeaderText(null);

		AIMS_GUI.AIMS_GUImain.loadSampleOrder();
		refreshScene();

		alert.showAndWait();
	}

	public void addButtontoOrderListTilePane() {
		Button newButton = new Button("Order" + (AIMSResources.cur_OrderIndex + 1));
		newButton.setPrefSize(70, 50);
		newButton.setId(String.valueOf(AIMSResources.cur_OrderIndex));
		newButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				AIMSResources.cur_OrderIndex = Integer.parseInt(newButton.getId());
				refreshScene();
			}
		});
		menu_OrderListTilepane.getChildren().add(newButton);
	}

	// Utility methods
	public void refreshScene() {
		AIMSResources.orderList.get(AIMSResources.cur_OrderIndex)
				.printOrdertoTableView(menu_ItemTableview, menu_CostTf, menu_CreatedDateTf);
		menu_orderLabel.setText("Order#" + (AIMSResources.cur_OrderIndex + 1));
	}

	private ObservableList<Media> getMediaList() {
		ObservableList<Media> list = FXCollections.observableArrayList();
		DigitalVideoDisc dvd = new DigitalVideoDisc("DVD01", "The Greatest Showman", "Drama, Musical", "Michael Gracey",
				105, 7.00f);
		CompactDisc cd = new CompactDisc("CD01", "American Standard", "Fantasy", "James Taylor", 9.99f);
		Book bk = new Book("BK01", "Dracula", "Horror", 4.29f);
		list.addAll(dvd, cd, bk);
		return list;
	}

}
