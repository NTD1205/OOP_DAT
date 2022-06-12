package hust.soict.hedspi.aims.gui;

import hust.soict.hedspi.aims.gui.res.AIMSResources;
import hust.soict.hedspi.aims.gui.res.ApplicationAlert;
import hust.soict.hedspi.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTrackGUIController {
	@FXML
	private TextField addTrack_titleTf;
	
	@FXML
	private TextField addTrack_lengthTf;
	
	@FXML
	private Button addTrack_addBtn;
	
	@FXML
	private Button addTrack_cancelBtn;
	
	
	public void handleAddBtn() {
		if (lengthIsValid()) {
			Track newTrack = new Track(addTrack_titleTf.getText(),Integer.parseInt(addTrack_lengthTf.getText()));			
			for(Track track : AIMSResources.cur_trackList) {
				if (track.getTitle().equals(newTrack.getTitle())) {
					ApplicationAlert.dupplicateTrackNameAlert();
					return;
				}
			}
			AIMSResources.cur_trackList.add(newTrack);
			AIMSResources.request.add(AIMSResources.ADDITEM_REFRESH_TRACK_TABLE_REQUEST);
			addTrack_titleTf.clear();
			addTrack_lengthTf.clear();
		}
	}
	
	public void handleCancelBtn(ActionEvent actionEvent) {
		Node  source = (Node)  actionEvent.getSource(); 
	    Stage stage  = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	public boolean lengthIsValid() {
		try {
			Integer.parseInt(addTrack_lengthTf.getText());
		} catch (NumberFormatException e) {
			ApplicationAlert.invalidLengthAlert();
			return false;
		}
		return true;
	}
}
