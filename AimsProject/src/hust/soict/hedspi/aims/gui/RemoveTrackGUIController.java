package hust.soict.hedspi.aims.gui;


import hust.soict.hedspi.aims.gui.res.AIMSResources;
import hust.soict.hedspi.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemoveTrackGUIController {
	@FXML
	private TextField removeTrack_IndexTf;
	
	@FXML
	private Button removeTrack_DeleteBtn;
	
	@FXML 
	private Button removeTrack_CancelBtn;
	
	public void removeTrackBtn() {
		for(Track track : AIMSResources.cur_trackList) {
			if(track.getTitle().equals(removeTrack_IndexTf.getText())) {
				AIMSResources.cur_trackList.remove(track);
			}
		}
		AIMSResources.request.add(AIMSResources.ADDITEM_REFRESH_TRACK_TABLE_REQUEST);	
	}
	
	public void cancelBtn(ActionEvent actionEvent) {
		Node  source = (Node)  actionEvent.getSource(); 
	    Stage stage  = (Stage) source.getScene().getWindow();
	    stage.close();
	}
}
