package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;

public abstract class Media implements Comparable<Media>{
	protected String title;
	protected String category;
	protected float cost;
	protected String id;
	
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public Media(String id, String title, float cost) {
		this.id = id;
		this.title = title;
		this.cost = cost;
	}
	
	public Media(String id, String title, String category, float cost) {
		this(id, title, cost);
		this.category = category;
	}
	
	public boolean equals(Object temp) throws NullPointerException, ClassCastException{
		if(temp != null) {
			if(temp instanceof Media) {
				if(this.getTitle().equalsIgnoreCase( ((Media)temp).getTitle() ) && this.getCost() == ((Media)temp).getCost())
					return true;
				return false;				
			}else {
				throw new ClassCastException("ERROR: Object casting");
			}
		}else {
			throw new NullPointerException("ERROR: Null pointerexception");
		}
	}
	
	public int compareTo(Media media) {
		if (this instanceof Book && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
			return -1;
		}
		if(this instanceof DigitalVideoDisc && media instanceof CompactDisc)
			return -1;
		if(this instanceof CompactDisc && (media instanceof DigitalVideoDisc || media instanceof Book))
			return 1;
		if(this instanceof DigitalVideoDisc && media instanceof Book)
			return 1;
		return 0;
	}

}
