package hust.soict.hedspi.aims.order;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.utils.MyDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Order extends Media{

    public static int nbOrders = 0 ;
    public static int itemAmountThreshold = 5;
    public static Float totalCostThreshold = 10F;
    public static Float itemCostThreshold = 5F;
    
    private int id;
    private MyDate dateOrdered;
    private List<Media> itemsOrdered = new ArrayList<Media>();
    
    private static BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));
    
    public double totalCost(){
    	Media luckyItem = this.getALuckyItem();
        double totalCost = 0.0;
        for (int i = 0; i<itemsOrdered.size();i++){
        	if (luckyItem != null && itemsOrdered.get(i) == luckyItem) continue;
            totalCost +=  itemsOrdered.get(i).getCost();
        }
        return totalCost;
    }
    
    public List<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void ShowOrder(){
        System.out.println("\n - The Orders' titles are: ");
        for(int i = 0; i<itemsOrdered.size(); i++){
            System.out.println(itemsOrdered.get(i).getTitle());
        }
    }
    
    public void printOrderformally(){
    	Media luckyItem = this.getALuckyItem();
        try {
			System.out.printf("***********************Order %d***********************\n", this.id);
			System.out.println("Date: " + this.dateOrdered.getDay() + "/" + this.dateOrdered.getMonth() + "/" + this.dateOrdered.getYear());
			System.out.println("Ordered Items:");
			for (int i =0; i<itemsOrdered.size(); i++){
			    DigitalVideoDisc dvd = (DigitalVideoDisc) itemsOrdered.get(i);
			    System.out.printf("%3d. - %20s - %20s - %20s - %4d mins: ",i+1,dvd.getTitle(),dvd.getCategory(),dvd.getDirector(),dvd.getLength());
			    
			    if(luckyItem != null && itemsOrdered.get(i) == luckyItem) System.out.printf("%6.2f (lucky!)\n",0f);
			     else System.out.printf("%6.2f\n",dvd.getCost());            
			}

			System.out.printf("Total costs: %.2f$ \n" ,this.totalCost());
			System.out.println("***************************************************");
		} catch (Exception NullPointerException) {
			// TODO Auto-generated catch block
			System.out.println("Item not exist!");
		}
    }
    
    public void printMixedOrderformally(){
    	Media luckyItem = this.getALuckyItem();
        try {
			System.out.printf("**********************************Order %d**************************************\n", this.id);
			System.out.println("Date: " + this.dateOrdered.getDay() + "/" + this.dateOrdered.getMonth() + "/" + this.dateOrdered.getYear());
			System.out.println("Ordered Items:");
			System.out.printf("#%10s | %30s | %30s|%6s\n","ID","Title","Category","Cost" );
			for (int i =0; i<itemsOrdered.size(); i++){
			    Media media = (Media) itemsOrdered.get(i);
			    System.out.printf("#%10s | %30s | %30s",media.getId(),media.getTitle(),media.getCategory());
			    
			    if(luckyItem != null && itemsOrdered.get(i) == luckyItem) System.out.printf("%6.2f$ (lucky!)\n",0f);
			     else System.out.printf("|%6.2f$\n",media.getCost());            
			}
			System.out.printf("Total costs: %.2f$ \n" ,this.totalCost());
			System.out.println("*******************************************************************************");
		} catch (Exception NullPointerException) {
			// TODO Auto-generated catch block
			System.out.println("Item not exist!");
		}
    }

    public void printOrdertoTextArea(TextArea textArea) {
    	Media luckyItem = this.getALuckyItem();
    	String text = "";
    	 try {
 			text += ("Date: " + this.dateOrdered.getDay() + "/" + this.dateOrdered.getMonth() + "/" + this.dateOrdered.getYear() + "\n");
 			text += "Ordered Items:\n";
 			text += String.format("#%10s | %30s | %30s|%6s\n","ID","Title","Category","Cost");           
 			for (int i =0; i<itemsOrdered.size(); i++){
 			    Media media = (Media) itemsOrdered.get(i);
 			    text += String.format("#%10s | %30s | %30s",media.getId(),media.getTitle(),media.getCategory());
 			    
 			    if(luckyItem != null && itemsOrdered.get(i) == luckyItem) System.out.printf("%6.2f$ (lucky!)\n",0f);
 			     else text += String.format("|%6.2f$\n",media.getCost());            
 			}
 			text += String.format("Total costs: %.2f$ \n" ,this.totalCost());
 			text += "*******************************************************************************\n";
 		} catch (Exception NullPointerException) {
 			System.out.println("Item not exist!");
 		} 
    	textArea.setText(text);
    }
    
    public void printOrdertoTableView(TableView tableView, TextField costTf, TextField createdDateTf) {
    	ObservableList<Media> list = FXCollections.observableArrayList();
    	 try {       
 			for (int i =0; i<itemsOrdered.size(); i++){
 			    Media media = (Media) itemsOrdered.get(i);
 			    list.add(media);
 			}
 			costTf.setText((String.valueOf(this.totalCost())));
 			createdDateTf.setText(this.dateOrdered.toString());
 		} catch (Exception NullPointerException) {
 			System.out.println("Item not exist!");
 		} 	
    	tableView.setItems(list);
    }
    
    public MyDate getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("You can't add anymore order");
            System.out.println("\t Failed to add: " + disc.getTitle());
        }else {
            itemsOrdered.add(itemsOrdered.size(), disc);
            System.out.println("You added " + disc.getTitle());

        }
    }
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdlist){
	    for(DigitalVideoDisc dvd : dvdlist){
	        addDigitalVideoDisc(dvd);
	    }
	}

	public void addDigitalVideoDiscGUI(DigitalVideoDisc dvd) {
		itemsOrdered.add(dvd);
	}
	
	public void addBook(Book book){
        if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("You can't add anymore item");
            System.out.println("\t Failed to add: " + book.getTitle());
        }else {
            itemsOrdered.add(itemsOrdered.size(), book);
            System.out.println("You added " + book.getTitle());

        }
    }
	public void addBook(Book... books){
	    for(Book book : books){
	        addBook(book);
	    }
	}
	
	public void addBookGUI(Book book) {
		itemsOrdered.add(book);
	}
	
	public void addCompactDisc(CompactDisc cd) throws NumberFormatException, IOException, PlayerException {
		if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("You can't add anymore item");
        }else {
        	System.out.println("Please enter track's ammout: ");
        	int trackAmount = Integer.parseInt(sysIn.readLine());
        	for(int i = 0; i< trackAmount; i++) {
        		cd.addTracks();
        	}
        	itemsOrdered.add(cd);
		}
	}
	
	public void addCompactDiscGUI(CompactDisc cd) {
		itemsOrdered.add(cd);
	}
	
    public Order(){
        if (nbOrders <= MAX_LIMITED_ORDERS ){
            nbOrders ++;
            itemsOrdered = new ArrayList<Media>(MAX_NUMBERS_ORDERED);
            this.id = nbOrders;
            dateOrdered = new MyDate();
        }else {
            System.out.println("Maximum amount of order reached!");
        }
    }

    public Order(DigitalVideoDisc... dvdlist){

        if (nbOrders < (MAX_LIMITED_ORDERS - 1)){
            nbOrders ++;
            itemsOrdered = new ArrayList<Media>(MAX_NUMBERS_ORDERED);
            dateOrdered = new MyDate();
            this.id = nbOrders;
            this.addDigitalVideoDisc(dvdlist);
        }else {
            System.out.println("Maximum amount of order reached!");
        }
    }
    
    public Media getALuckyItem() {
    	if(itemsOrdered.size() == 0) {
    		System.out.println("There is nothing in the order!");
    		return null;
    	}

    	if(this.getCost() >= Order.totalCostThreshold && this.getItemsOrdered().size() >= Order.itemAmountThreshold) {
    		if (Math.random() > 0) {
    			Collections.shuffle(this.itemsOrdered);
    			for(int i = 0; i<this.itemsOrdered.size(); i++) {
    				if(this.itemsOrdered.get(i).getCost() <= this.totalCost()/this.itemsOrdered.size() && this.itemsOrdered.get(i).getCost() <= Order.itemCostThreshold) {
    					Collections.sort(this.itemsOrdered);
    					return this.itemsOrdered.get(i);
    				}
    			}
        	}
    	}
    	Collections.sort(this.itemsOrdered);
		return null;
    }

	public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if(itemsOrdered.size() <=0){
            System.out.println("You can't remove anymore order");
        }else if(itemsOrdered.contains(disc)) {
            itemsOrdered.remove(disc);	
        }
    }
    
	public void removeMediaByID(int id) {
		try {
			itemsOrdered.remove(id-1);		
		} catch (Exception IndexOutOfBoundsException) {
			// TODO Auto-generated catch block
			System.out.println("Item not found (id = " + id +") ! No items was removed!");
		}		
	}
    
	public static boolean UserConfirmToPlay(String itemType) throws NumberFormatException, IOException {
		System.out.println("Do you want to play the " + itemType + "?");
    	System.out.println("-------------------------------");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int choice = Integer.parseInt(sysIn.readLine());
    	if(choice == 1)
    		return true;
    	else 
    		return false;
	}
	
	public static String InputItemId() throws IOException {
		System.out.println("Enter id for item:");
		return sysIn.readLine();
	}

	public void LoadSampleOrder() {
		Book book1 = new Book("book0");
		book1.id = "BK01";
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("dvd1","","",10,22); dvd1.id = "DVD01";
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("dvd2","","",12,0); dvd2.id = "DVD02";
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("dvd3","","",14,0); dvd3.id = "DVD03";
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("dvd4","","",0,0); dvd4.id = "DVD04";

		
		itemsOrdered.add(dvd3);
		itemsOrdered.add(dvd4);
		itemsOrdered.add(dvd1);
		itemsOrdered.add(dvd2);
		itemsOrdered.add(book1);
		
		
		Track track1 = new Track("My",1);
		Track track2 = new Track("Tail",1);
		Track track3 = new Track("Sparks",0);
		Track track4 = new Track("Electric",10);
		
		CompactDisc cd1 = new CompactDisc("Flooding Tokyo","movie",12); cd1.id = "CD01";
		CompactDisc cd2 = new CompactDisc("Asterite in your backyard","movie",24); cd2.id = "CD02";
		CompactDisc cd3 = new CompactDisc("Italian shoemaker","movie",36); cd3.id = "CD03";
		
		cd1.addTracks(track1,track2);
		cd2.addTracks(track1,track2,track3);
		cd3.addTracks(track1,track2,track4);
		
		itemsOrdered.add(cd3);
		itemsOrdered.add(cd2);
		itemsOrdered.add(cd1);	
	
	}
}
