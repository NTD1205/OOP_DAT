package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.exceptions.PlayerException;

public class Track implements Playable, Comparable<Track>{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}
	
	public String getMessage() {
		return "\nPlaying Track: " + this.getTitle() + "\nTrack length: " + this.getLength();
	}
	
	public boolean equals(Object object) {
		Track track = (Track) object;
		if(title.equalsIgnoreCase(track.title) && length == track.length)
			return true;
		return false;
	}
	
	public int compareTo(Track track) {
		if(this.title.compareToIgnoreCase(track.title) < 0)
			return -1;
		else if(this.title.compareToIgnoreCase(track.title) == 0)
			return 0;
		else return 1;
	}
}
