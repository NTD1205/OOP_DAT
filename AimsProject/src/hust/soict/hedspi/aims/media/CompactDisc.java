package hust.soict.hedspi.aims.media;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.order.Order;

public class CompactDisc extends Disc implements Playable, Comparable<Object>{
	private String artist;
	private int length = 0;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc() throws IOException {
		BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter CD's title: ");
		this.title = sysIn.readLine();
		System.out.println("Enter CD's category: ");
		this.category = sysIn.readLine();
		System.out.println("Enter cost: ");
		this.cost = Float.parseFloat(sysIn.readLine());
		System.out.println("Enter artist's name");
		this.artist = sysIn.readLine();
	}
	public CompactDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public CompactDisc(String id, String title, String category, String artist, float cost) {
		this(title,category,cost);
		this.id = id;
		this.artist = artist;
	}
	
	
	public void addTrack(String title, int length) {
		for (Track track : tracks) {
			if(track.getTitle() == title) {
				System.out.println("Track "+title+" is already added!");
				return;
			}	
		}
		tracks.add(new Track(title,length));
		System.out.println("Track "+title+" is added!");
	}
	public void addTracks() throws IOException, PlayerException {
		String title;
		int length;
		System.out.println("Please enter track's name: ");
		title = sysIn.readLine();
		System.out.println("Please enter track's length: ");
		length = Integer.parseInt(sysIn.readLine());		
		this.addTrack(title, length);
		if(Order.UserConfirmToPlay("Track"))
			this.tracks.get(this.tracks.size()-1).play();
	}
	public void addTracks(Track...tracks ) {
		for(Track track : tracks) 
			this.addTrack(track.getTitle(), track.getLength());
	}
	public void removeTrack(String title) {
		for (Track track : tracks) {
			if(track.getTitle() == title) {
				tracks.remove(track);
				System.out.println("Track "+title+" is removed!");
				return;
			}	
		}
		System.out.println("Track "+title+"is not found!");
	}
	
	public int getLength() {
		for (Track track : tracks) {		
			this.length += track.getLength();
		}
		return length;
	}
	public int getTrackAmount() {
		return tracks.size();
	}
	
	public void play() throws PlayerException {
		if (!(this.getLength() > 0)) {
			throw new PlayerException("CD's length is illegal!");
		}
		for (Track track : tracks) {
			try {
				track.play();
			} catch (PlayerException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof CompactDisc)) {
			return super.compareTo(o);
		}else {
			CompactDisc cd2 = (CompactDisc) o;
			if(Integer.compare(this.tracks.size(),cd2.tracks.size()) != 0){
				return Integer.compare(this.tracks.size(), cd2.tracks.size());
			}else {
				return Integer.compare(this.getLength(),cd2.getLength());
			}
		}
	}

	public List<Track> getTracks() {
		return tracks;
	}


}
