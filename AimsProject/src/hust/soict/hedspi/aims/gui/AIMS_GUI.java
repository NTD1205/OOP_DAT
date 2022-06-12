package hust.soict.hedspi.aims.gui;


import java.io.IOException;
import java.util.ArrayList;

import hust.soict.hedspi.aims.gui.res.AIMSResources;
import hust.soict.hedspi.aims.gui.res.ApplicationAlert;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.MediaType;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.MemoryDaemon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class AIMS_GUI extends Application{

	public static final int Alert_createNewOrder_successful = 1;
	public static final int Alert_createNewOrder_fail = 2;
	public static final int foo = 3;
	public static AIMS_GUI AIMS_GUImain;
	public static Stage menuStage;
	
	public static Stage getMenuStage() {
		return menuStage;
	}
    public static void main(String args[]) throws Exception{
    	MemoryDaemon md = new MemoryDaemon();
		Thread thread = new Thread(md);
		thread.setDaemon(true);  
		launch(args);
    }
    
    @Override  
    public void start(Stage primaryStage) throws Exception {
    	//INITIALIZATION
    	
    	AIMSResources.orderList = new ArrayList<>();
    	AIMSResources.cur_OrderIndex = -1;
    	AIMS_GUImain = new AIMS_GUI();
    	
    	Parent root = FXMLLoader.load(getClass().getResource("MenuGUI.fxml"));
    	Scene menuScene = new Scene(root);
    	primaryStage.setScene(menuScene);
    	primaryStage.setTitle("AIMS_menu");
    	menuStage = primaryStage;
    	primaryStage.show();
    }
    
	public int createNewOrder() {
		if (AIMSResources.orderList.size() < Order.MAX_LIMITED_ORDERS) {
			Order newOrder = new Order();
			AIMSResources.orderList.add(newOrder);
			AIMSResources.cur_OrderIndex = (AIMSResources.orderList.size()-1);
			return Alert_createNewOrder_successful;
		}
		else {		
			return Alert_createNewOrder_fail;
		}	
	}
	
	public void addItem(int mediaID, Book book,DigitalVideoDisc dvd, CompactDisc cd) throws NumberFormatException, IOException {
		if(AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).getItemsOrdered().size() >10) {
			ApplicationAlert.orderItemMaximumReachedAlert();	
		} else {
	    	switch (mediaID) {
	    		case MediaType.BOOK: {
	    			AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).addBookGUI(book);			
	    			break;
	    		}
	    		case MediaType.CD: {
	    			AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).addCompactDiscGUI(cd); 
	    			break; 
	    		}
	    		case MediaType.DVD: {
	    			AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).addDigitalVideoDiscGUI(dvd);
	    			break;
	    		}
	    		default: return;
	    	}
		}
	}

	public void removeItembyID(Order cur_Order) throws NumberFormatException, IOException {

		cur_Order.removeMediaByID(0);
	}
	
	public void loadSampleOrder() {
		AIMSResources.orderList.get(AIMSResources.cur_OrderIndex).LoadSampleOrder();
	}
	
}

