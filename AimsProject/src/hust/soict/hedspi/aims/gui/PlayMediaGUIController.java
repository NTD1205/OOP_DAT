package hust.soict.hedspi.aims.gui;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.gui.res.AIMSResources;
import hust.soict.hedspi.aims.gui.res.ApplicationAlert;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PlayMediaGUIController implements Initializable{
	@FXML
	private Label PlayMediaGUI_TitleLabel;
	
	@FXML
	private VBox PlayMediaGUI_ContentVBox;
	
	@FXML
	private TextField PlayMediaGUI_IDInputTextField;

	@FXML
	private Button PlayMediaGUI_PlayBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		PlayMediaGUI_PlayBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String id = PlayMediaGUI_IDInputTextField.getText();
				for(int i = 0; i<AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getItemsOrdered().size(); i++) {
					if (AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getItemsOrdered().get(i).getId().equals(id)) {
						if(AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getItemsOrdered().get(i) instanceof DigitalVideoDisc) {
							try {
								playDVD((DigitalVideoDisc) AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getItemsOrdered().get(i));
							} catch (PlayerException e) {
								ApplicationAlert.illegalDVDLengthAlert();
							}
						} else if (AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getItemsOrdered().get(i) instanceof CompactDisc) {
							try {
								playCD((CompactDisc) AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getItemsOrdered().get(i));
							} catch (PlayerException e) {
								ApplicationAlert.illegalCDTrackLengthAlert();
							}
						} else {
							ApplicationAlert.playingNonPlayableAlert();
						}
					}
				}
			}
		});
	}
	
	public void playCD(CompactDisc cd) throws PlayerException {
		PlayMediaGUI_TitleLabel.setText("Playing CD \"" + cd.getTitle() + "\"");
		if(cd.getLength() <=0) 
			throw new PlayerException();
		
		for (Track track: cd.getTracks()) {
			if (track.getLength() <= 0) 
				throw new PlayerException();
			Label trackLabel = new Label();
			trackLabel.setText("Track: " + track.getTitle() + " Length: " + track.getLength());
			PlayMediaGUI_ContentVBox.getChildren().add(trackLabel);
		}
		
		Label totalCDLengthLabel = new Label();
		totalCDLengthLabel.setText("CD's length: " + cd.getLength());
		PlayMediaGUI_ContentVBox.getChildren().add(totalCDLengthLabel);
	}
	
	public void playDVD(DigitalVideoDisc dvd) throws PlayerException {
		if (dvd.getLength() <= 0)
			throw new PlayerException();
		PlayMediaGUI_TitleLabel.setText("Playing DVD \"" + dvd.getTitle() + "\"");
		Label totalDVDLengthLabel = new Label();
		totalDVDLengthLabel.setText("DVD's length: " + dvd.getLength());
		PlayMediaGUI_ContentVBox.getChildren().add(totalDVDLengthLabel);
	}	
}
