package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TestController {
	
	@FXML
	private TextField InputText;
	
	public void Submit (ActionEvent event) {
		String inputText = InputText.getText();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText(inputText);
		alert.show();
	}
}
