package hust.soict.hedspi.aims.gui;

import hust.soict.hedspi.aims.gui.res.AIMSResources;

import hust.soict.hedspi.aims.gui.res.ApplicationAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteItemGUIController {
	@FXML
	private TextField deleteItem_IDTf;

	@FXML
	private Button deleteItem_DeleteBtn;

	@FXML
	private Button deleteItem_CancelBtn;

	public void deleteItem_DeleteBtn() {

		if (deleteItem_IDTf.getText().isEmpty()) {
			ApplicationAlert.itemIDIsEmptyAlert();
			return;
		}

		if (AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getItemsOrdered()
				.removeIf(item -> item.getId().equals(deleteItem_IDTf.getText()))) {
			AIMSResources.request.add(AIMSResources.MENU_REFRESH_SCREEN_REQUEST);
			deleteItem_IDTf.clear();
		} else {
			ApplicationAlert.itemIDNotFoundAlert(deleteItem_IDTf.getText());
		}
	}
	public void deleteItem_CancelBtn(ActionEvent actionEvent) {
		Node source = (Node) actionEvent.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
}
