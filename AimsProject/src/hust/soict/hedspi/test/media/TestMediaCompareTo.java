package hust.soict.hedspi.test.media;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.disc.Track;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		java.util.Collection<Media> collection = new java.util.ArrayList<Media>();
		// Enter from keyboard
//		Scanner sc = new Scanner(System.in);
//		int select;
//		do {
//			showMenu();
//			select = sc.nextInt();
//			switch(select) {
//			case 1:
//				addDvdToOrder(collection);
//				break;
//			case 2:
//				addCdToOrder(collection);
//				break;
//			case 3:
//				display(collection);
//				break;
//			case 0:
//				sc.close();
//				System.out.println("Bye!!!");
//				break;
//			default:
//				System.err.println("Error input enter, again!");
//				break;
//			}
//		} while (select != 0);
		
		// Data test
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("a123", "adasdj", "film", 12, 128);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("a124", "jklasoid", "film",223, 30);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("a123", "biuad", "music", 22, 83);
		CompactDisc cd1 = new CompactDisc("a82u", "akljsd", "music", "jdjfwa", 123);
		CompactDisc cd2 = new CompactDisc("ljkasd", "kajsd", "music", "asad", 32);
		Book b1 = new Book("acn", "alkjsd", 821);
		Book b2 = new Book("ajd", "alkjsd", 123);
		
		collection.add(b2);
		collection.add(dvd1);
		collection.add(cd1);
		collection.add(dvd2);
		collection.add(cd2);
		collection.add(dvd3);
		collection.add(b1);
		 
		display(collection);
		
	}
	
	private static void display(java.util.Collection<Media> collection) {
		Iterator<Media> iterator = collection.iterator();
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s : %-12s| %-5s | %-5s%n", "STT", "Type", "ID", "Title", "Category", "Total", "Number", "Length");
		int i = 1;
		while(iterator.hasNext()) {
			Media media = iterator.next();
			if(media instanceof Book) {
				System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s : %-10s$ |%n", i, "Book", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
			}else if(media instanceof DigitalVideoDisc) {
				System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s : %-10s$ |%n", i, "DVD", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
			}else if(media instanceof CompactDisc) {
				System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s : %-10s$ | %-5s | %-5s%n", i, "CD", media.getId(), media.getTitle(), media.getCategory(), media.getCost(), ((CompactDisc)media).getTracks().size(), ((CompactDisc) media).getLength());
			}
			i++;
		}
		java.util.Collections.sort((List<Media>)collection);
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s : %-12s| %-5s | %-5s%n", "STT", "Type", "ID", "Title", "Category", "Total", "Number", "Length");
		i = 1;
		while(iterator.hasNext()) {
			Media media = iterator.next();
			if(media instanceof Book) {
				System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s : %-10s$ |%n", i, "Book", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
			}else if(media instanceof DigitalVideoDisc) {
				System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s : %-10s$ |%n", i, "DVD", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
			}else if(media instanceof CompactDisc) {
				System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s : %-10s$ | %-5s | %-5s%n", i, "CD", media.getId(), media.getTitle(), media.getCategory(), media.getCost(), ((CompactDisc)media).getTracks().size(), ((CompactDisc) media).getLength());
			}
			i++;
		}
		System.out.println("----------------------------------");
	}
	
	private static void addDvdToOrder(java.util.Collection<Media> collection) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("\tNhap id: ");
		String id = sc.nextLine();
		System.out.printf("\tNhap title: ");
		String title = sc.nextLine();
		System.out.printf("\tNhap category: ");
		String category = sc.nextLine();
		System.out.printf("\tNhap director: ");
		String director = sc.nextLine();
		System.out.printf("\tNhap cost: ");
		float cost = sc.nextFloat();
		System.out.printf("\tNhap length: ");
		int length = sc.nextInt();
		sc.nextLine();
		DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, length, director, cost);
		String ask;
		do {
			System.out.printf("***\tBan muon nghe thu khong(yes|no): ");
			ask = sc.nextLine();
			switch (ask) {
			case "yes":
				System.out.println("===============================");
				try {
					dvd.play();
				} catch (PlayerException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("===============================");
				break;
			case "no":
				break;
			default:
				System.err.println("Nhap sai cu phap");
			}
		} while (ask.equalsIgnoreCase("yes") == false && ask.equalsIgnoreCase("no") == false);
		collection.add(dvd);
	}
	
	private static void addCdToOrder(java.util.Collection<Media> collection) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("\tNhap id: ");
		String id = sc.nextLine();
		System.out.printf("\tNhap title: ");
		String title = sc.nextLine();
		System.out.printf("\tNhap category: ");
		String category = sc.nextLine();
		System.out.printf("\tNhap artist: ");
		String artist = sc.nextLine();
		System.out.printf("\tNhap cost: ");
		float cost = sc.nextFloat();
		CompactDisc cd = new CompactDisc(id, title, category, artist, cost);
		System.out.printf("\tSo luong Track: ");
		int count = sc.nextInt();
		while(count <= 0) {
			System.err.println("So luong Track phai lon hon 0");
			System.out.printf("\tSo luong Track: ");
			count = sc.nextInt();
		}
		sc.nextLine();
		Track track = null;
		String titleTrack;
		int lengthTrack;
		for(int i = 0; i < count; i++) {
			System.out.println("***\tTrack " + (i+1));
			System.out.printf("\tNhap title cua track: ");
			titleTrack = sc.nextLine();
			System.out.printf("\tNhap length cua track: ");
			lengthTrack = sc.nextInt();
			track = new Track(titleTrack, lengthTrack);
			cd.addTrack(track);
			sc.nextLine();
		}
		String ask;
		do {
			System.out.printf("***\tBan muon nghe thu khong(yes|no): ");
			ask = sc.nextLine();
			switch (ask) {
			case "yes":
				System.out.println("===============================");
				cd.play();
				System.out.println("===============================");
				break;
			case "no":
				break;
			default:
				System.err.println("Nhap sai cu phap");
			}
		} while (ask.equalsIgnoreCase("yes") == false && ask.equalsIgnoreCase("no") == false);
		collection.add(cd);
	}
	
	private static void showMenu() {
		System.out.println("Select add DVD or CD "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. DVD"); 
		System.out.println("2. CD"); 
		System.out.println("3. Display"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3");
	}

}


