package hust.soict.hedspi.aims.gui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.MemoryDaemon;
public class Aims {
	private static BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws Exception{
//		Lab 03;
//    	System.out.println("Lab03");
//        Order anOrder = new Order();
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers",87,19.95f);
//        anOrder.addDigitalVideoDisc(dvd1);
//
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",124,24.95f);
//        anOrder.addDigitalVideoDisc(dvd2);
//
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation","John Musker",90,18.99f);
//        anOrder.addDigitalVideoDisc(dvd3);
//
//        System.out.print("The total cost is: ");
//        System.out.println(anOrder.totalCost());
        
//        Lab04
//        System.out.println("Lab04");
//
//        anOrder.ShowOrder();
//        anOrder.removeDigitalVideoDisc(dvd1);
//        anOrder.ShowOrder();
//
//        DigitalVideoDisc[] dvdlist = {dvd1, dvd2, dvd3,dvd1,dvd2,dvd3,dvd1,dvd2,dvd3};
//        anOrder.addDigitalVideoDisc(dvd1);
//        anOrder.printOrderformally();
//
//        DigitalVideoDisc dvd4 = new DigitalVideoDisc("How to get A+ in OOP","Lecture","Professor T",30,10.20f);
//
//	
//        Order specialOrder = new Order();
//        specialOrder.addDigitalVideoDisc(dvd4);
//        specialOrder.printOrderformally();
//
//        Order specialOrder2 = new Order();
//        Order specialOrder3 = new Order();
//        Order specialOrder4 = new Order();
//        Order specialOrder5 = new Order();
        
//        Lab05
//        System.out.printf("\nLab05\n");
//        
//        DiskTest.Test();
    	
//    	  Lab06 + 7 + 8
    	MemoryDaemon md = new MemoryDaemon();
		Thread thread = new Thread(md);
		thread.setDaemon(true);
//		thread.start();
    	showMenu();
    	
    		           
    }
    
    public static void showMenu() throws NumberFormatException, IOException, PlayerException {
    	int Option = -1;
    	
    	Order cur_Order = null;
    	cur_Order = createOrder(cur_Order);
    	while(true) { 
	    	System.out.println("Order Management Application: ");
	    	System.out.println("-------------------------------");
	    	System.out.println("1. Create new order");
	    	System.out.println("2. Add item to the order");
	    	System.out.println("3. Delete item by id");
	    	System.out.println("4. Display the items list of order");
	    	System.out.println("5. Sort list");
	    	System.out.println("6. Load Sample Order");
	    	System.out.println("0. Exit");
	    	System.out.println("-------------------------------");
	    	System.out.println("Please choose a number: 0-1-2-3-4:");
	    	Option = Integer.parseInt(sysIn.readLine());
	    	switch (Option) {
	    		case 1: cur_Order = createOrder(cur_Order); break;
	    		case 2: addItem(cur_Order); break; 
	    		case 3: removeItembyID(cur_Order);break;
	    		case 4: try {
					cur_Order.printMixedOrderformally();
				} catch (Exception NullPointerException) {
					System.out.println("Order not exist!");
				} break;
	    		case 5: {
	    			Collections.sort((List)cur_Order.getItemsOrdered());
	    			System.out.println("The Order has been sorted");
	    			break;
	    		}
	    		case 6: {
	    			cur_Order.LoadSampleOrder();
	    			break;
	    		}
	    		default: return;
	    	}
    	}
    }

	public static Order createOrder(Order lastOrder) {
		Order cur_Order = new Order();
		if (Order.nbOrders <= Order.MAX_LIMITED_ORDERS) {
			System.out.println("New Order has been created!");
			return cur_Order;
		}
		else {
			System.out.println("New order has not been created due to number of orders exceeded limit!");
			return lastOrder;
		}		
	}
	
	public static void addItem(Order cur_Order) throws NumberFormatException, IOException, PlayerException {
    	int Option = -1;
    	
    	while(true) { 
	    	System.out.println("Which type of item do you want to add ");
	    	System.out.println("-------------------------------");
	    	System.out.println("1. Book");
	    	System.out.println("2. DigitalVideoDisc");
	    	System.out.println("3. CompactDisc");	
	    	System.out.println("0. Return to Main Menu");
	    	System.out.println("-------------------------------");
	    	System.out.println("Please choose a number: 0-1-2-3:");
	    	Option = Integer.parseInt(sysIn.readLine());
	    	switch (Option) {
	    		case 1: {
	    			Book book = new Book();
	    			book.id = Order.InputItemId();
	    			cur_Order.addBook(book);			
	    			break;
	    		}
	    		case 2: {
	    			DigitalVideoDisc dvd = new DigitalVideoDisc();
	    			dvd.id = Order.InputItemId();
	    			cur_Order.addDigitalVideoDisc(dvd);	 
	    			if(Order.UserConfirmToPlay("DVD"))
						try {
							dvd.play();
						} catch (PlayerException e) {
							e.printStackTrace();
							System.err.println(e.getMessage());
							System.err.println(e.toString());
						}
	    			break; 
	    		}
	    		case 3: {
	    			CompactDisc cd = new CompactDisc();
	    			cd.id = Order.InputItemId();
	    			cur_Order.addCompactDisc(cd);
	    			if(Order.UserConfirmToPlay("CD"))
						try {
							cd.play();
						} catch (PlayerException e) {
							e.printStackTrace();
							System.err.println(e.getMessage());
							System.err.println(e.toString());
						}
	    			break;
	    		}
	    		default: return;
	    	}
    	}
	}
	
	public static void removeItembyID(Order cur_Order) throws NumberFormatException, IOException {
		int id = -1;
		System.out.println("Enter id of item to be removed: ");
		id = Integer.parseInt(sysIn.readLine());
		cur_Order.removeMediaByID(id);
		System.out.println("Removal opreation ended ");
	}
}

