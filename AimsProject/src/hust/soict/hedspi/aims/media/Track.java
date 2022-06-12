package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable, Comparable<Object>{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track() {
	}
	public Track(String title) {
		this.title = title;
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
    public void play() throws PlayerException {
    	if (this.getLength() >0) {
    		System.out.println("Playing Track: " + this.getTitle());
        	System.out.println("Track's length: " + this.getLength());
    	} else {
    		System.err.println("Track's length must be positive!");
    		throw new PlayerException("Track's length is illegal!");
    	}
    }
    
    @Override
    public boolean equals(Object obj) {    
        if (obj == this) { 
            return true; 
        } 
        if (!(obj instanceof Track)) { 
            return false; 
        } 
        Track track2 = (Track) obj; 
        return (this.title == track2.title && this.length == track2.length);
    }
	@Override
	public int compareTo(Object o) {
		Track track2 = (Track) o;
		return this.getTitle().compareTo(track2.getTitle());
	}
}
