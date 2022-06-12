package hust.soict.globalict.aims.gui.res;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ApplicationAlert {
	private static Alert alert = new Alert(AlertType.WARNING);
	
	public static void allRequiredInformationNotFilledAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("All required informations must be filled!");
		alert.show();
	}
	
	public static void invalidCostAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("Item's cost must be a number!");
		alert.show();
	}
	
	public static void invalidLengthAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("Disc's length must be an integer!");
		alert.show();
	}
	
	public static void mediaTypeNotChosenAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("Please choose a mediaType!");
		alert.show();
	}
	
	public static void orderItemMaximumReachedAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("You can not add any more item to this order!");
		alert.show();
	}
	
	public static void newOrderCreatedAlert() {
		alert.setTitle("ERROR");
		alert.setHeaderText(null);
		alert.setContentText("New Order has been created!");
		alert.show();
	}
	
	public static void orderMaximumReachedAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("Maximum amount of order reached!");
		alert.show();
	}
	
	public static void noChosenOrderAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("You have no chosen order!");
		alert.show();
	}
	
	public static void sortedListAlert() {
		alert.setContentText("List has been sorted!");
		alert.setHeaderText(null);
		alert.setTitle("NOTICE!");
		alert.show();
	}
	
	public static void dupplicateTrackNameAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("Dupplicate track name! Please add track with unique name to each CD!");
		alert.show();
	}
	
	public static void itemIDIsEmptyAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("Item's ID must not be blank!");
		alert.show();
	}
	
	public static void itemIDNotFoundAlert(String itemID) {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("Item with ID: " +itemID + " not found!");
		alert.show();
	}
	
	public static void illegalDVDLengthAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("DVD has illegal length!");
		alert.show();
	}
	
	public static void illegalCDTrackLengthAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("CD or its track has illegal length!");
		alert.show();
	}
	
	public static void playingNonPlayableAlert() {
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);
		alert.setContentText("The item is not playable!");
		alert.show();
	}
}
