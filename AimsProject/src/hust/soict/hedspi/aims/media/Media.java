package hust.soict.hedspi.aims.media;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Media implements Comparable<Object>{

	
	public Media() {
	}
	public Media(String title) {
		this.title = title;
	}
	public Media(String title, String category) {
		this(title);
		this.category = category;
	}
	public Media(String title, String category,float cost) {
		this(title,category);
		this.cost = cost;
	}

	protected static BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));
	protected String title;
	protected String category;
	protected float cost;
	public String id;
	public String getId() {
		return id;
	}
	
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	
	public void addMedia() {
		
	}
	
	@Override
	public boolean equals(Object obj) {    
        if (obj == this) { 
            return true; 
        } 
        if (!(obj instanceof Media)) { 
            return false; 
        } 
        Media media2 = (Media) obj; 
        return (this.title == media2.title && this.cost == media2.cost);
    } 
	
	@Override
	public int compareTo(Object o) {
		Media media2 = (Media) o;
		if(this.equals(media2)) 
			return 0;
		return this.id.compareTo(media2.id);
	}
}
