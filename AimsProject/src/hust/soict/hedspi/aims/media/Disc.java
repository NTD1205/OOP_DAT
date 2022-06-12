package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media {
	private int length;
	
	private String director;
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	public Disc() {
		
	}
	public Disc(String title, String category,float cost) {
		super(title,category,cost);
	}
	
}
