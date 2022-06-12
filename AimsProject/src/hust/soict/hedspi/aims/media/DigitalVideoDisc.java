package hust.soict.hedspi.aims.gui;


import java.io.IOException;
import java.util.Scanner;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable, Comparable<Object> {

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private String director;
    private int length;
    
    public DigitalVideoDisc() throws NumberFormatException, IOException{
    	System.out.println("Enter dvd's Title: "); 
		this.title = sysIn.readLine();
		System.out.println("Enter dvd's category: "); 
		this.category = sysIn.readLine();
		System.out.println("Enter dvd's cost: "); 
		this.cost = Float.parseFloat(sysIn.readLine());
		System.out.println("Enter dvd's length: "); 
		this.length = Integer.parseInt(sysIn.readLine());
    }
    
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category) {
        this(title);
        this.category = category;
    }

    public DigitalVideoDisc(String title, String category, String director) {
        this(title,category);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title,category,director);
        this.length = length;
        this.cost = cost;
    }

    public DigitalVideoDisc(String id, String title, String category, String director, int length, float cost) {
    	this(title,category,director,length,cost);
    	this.id = id;
    }

    public void cloneTo(DigitalVideoDisc dvd){
        dvd.title = this.getTitle();
        dvd.director = this.getDirector();
        dvd.category = this.getCategory();
        dvd.cost = this.getCost();
        dvd.length = this.getLength();
    }


    public static void DVDswap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        DigitalVideoDisc tmp = new DigitalVideoDisc("");
        dvd1.cloneTo(tmp);
        dvd2.cloneTo(dvd1);
        tmp.cloneTo(dvd2);
    }
    
    public boolean search(String Title) {
    	String[] split_thisTitle = this.getTitle().split("\\s");
    	String[] split_Title = Title.split("\\s");
    	
    	int match_count = 0;
    	
    	for (int i=0; i<split_thisTitle.length; i++) {
    		for (int j = 0; j<split_Title.length;j++) {
    			if(split_thisTitle[i].toLowerCase().equals(split_Title[j].toLowerCase())) match_count++;
    		}
    	}
		if (match_count == split_Title.length) return true;
		else return false;	
    }
    public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof DigitalVideoDisc)) {
			return super.compareTo(o);
		}else {
			DigitalVideoDisc dvd2 = (DigitalVideoDisc) o;
			return Float.compare(this.cost, dvd2.cost);
		}
	}
}
