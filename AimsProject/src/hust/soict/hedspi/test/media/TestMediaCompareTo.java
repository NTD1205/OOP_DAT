package hust.soict.hedspi.test.media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.media.*;
public class TestMediaCompareTo {
	public static void main(String args[]) {
		LoadSampleOrder(Order);
		TestSort(Order);		
	}
	
	public static void LoadSampleOrder(List<Media> Order) {
		Book book1 = new Book("oof0");
		book1.id = "BK01";
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("oof1","","",10,0); dvd1.id = "DVD01";
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("oof2","","",12,0); dvd2.id = "DVD02";
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("oof3","","",14,0); dvd3.id = "DVD03";
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("oof4","","",16,0); dvd4.id = "DVD04";

		
		Order.add(dvd3);
		Order.add(dvd4);
		Order.add(dvd1);
		Order.add(dvd2);
		Order.add(book1);
		
		
		Track track1 = new Track("My",1);
		Track track2 = new Track("Tail",1);
		Track track3 = new Track("Sparks",1);
		Track track4 = new Track("Electric",10);
		
		CompactDisc cd1 = new CompactDisc("Flooding Tokyo","movie",0); cd1.id = "CD01";
		CompactDisc cd2 = new CompactDisc("oAsterite in your backyard","movie",0); cd2.id = "CD02";
		CompactDisc cd3 = new CompactDisc("zItalian shoemaker","movie",0); cd3.id = "CD03";
		
		cd1.addTracks(track1,track2);
		cd2.addTracks(track1,track2,track3);
		cd3.addTracks(track1,track2,track4);
		
		Order.add(cd3);
		Order.add(cd2);
		Order.add(cd1);	
	}
	
	public static void TestSort(List<Media> Order) {
		Iterator<Media> iterator = Order.iterator();	
		System.out.println("------------------------------------------");
		System.out.println("The current items in collections are");		
		while (iterator.hasNext()) {
			System.out.println( ((Media)iterator.next()).getTitle());
		}		
		
		Collections.sort((List)Order);
		
		iterator = Order.iterator();
		System.out.println("------------------------------------------");
		System.out.println("The current items in collections are");		
		while (iterator.hasNext()) {
			System.out.println(((Media)iterator.next()).getTitle());
		}
	}
	
	private static List<Media> Order = new ArrayList<Media>();	
}
