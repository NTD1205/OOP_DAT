package hust.soict.hedspi.aims.media;

public class MediaType {
	private String mediaType;
	private int mediaID;
	
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public int getMediaID() {
		return mediaID;
	}
	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}
	
	public static final int BOOK = 1;
	public static final int CD = 2;
	public static final int DVD = 3;
	
	//Book: 1; CD: 2; DVD: 3;
	
	public MediaType() {
	
	}
	
	public MediaType(int mediaID) {
		this.mediaID = mediaID;
		switch(mediaID) {
		case 1: this.mediaType = "Book";break;
		case 2: this.mediaType = "CD";break;
		case 3: this.mediaType = "DVD";break;
		default: System.out.println("Error at /AimsProject/src/hust/soict/hedspi/aims/media/MediaType.java: mediaID not found!");break;
		}
	}		
	
	@Override
	public String toString() {
		return this.mediaType;
	}
}
