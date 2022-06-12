package hust.soict.hedspi.aims.gui;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media implements Comparable<Object> {

	private String content;
	List<String> contentTokens = new ArrayList<String>();
	Map<String,Integer> wordFrequency = new TreeMap<String,Integer>();
	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String... authorNames) {
		for(String authorName : authorNames) {
			if (!this.authors.contains(authorName)) {
				this.authors.add(authorName);
			}else {
				System.out.println("Author" + authorName + " is already included!");
			}
		}
	}
	public void removeAuthor(String authorName) {
		if(this.authors.contains(authorName)) {
			this.authors.remove(authorName);
		} else {
			System.out.println("Author not found!");
		}		
	}

	public Book() throws IOException {
		System.out.println("Enter book's Title: "); 
		this.title = sysIn.readLine();
		System.out.println("Enter book's category: "); 
		this.category = sysIn.readLine();
		System.out.println("Enter book's cost: "); 
		this.cost = Float.parseFloat(sysIn.readLine());
		System.out.println("Do you want to load sample content?\n1.Yes\n2.No");
		int Option = Integer.parseInt(sysIn.readLine());
		if(Option == 1) {
			this.LoadSampleContent();
			System.out.println("Sample content loaded");
		}	
	}
	public Book(String title) {
		this.title = title;
	}
	public Book(String id, String title, String category, float cost) {
		this(title);
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public Book(String id, String title, String category, float cost,String[] authorList,String content) {
		this(id, title, category, cost);
		for(String author : authorList) {
			this.authors.add(author);
		}
		this.content = content;
	}
	
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Book)) {
			return super.compareTo(o);
		}else {
		Book book2 = (Book) o;
		return this.getTitle().compareTo(book2.getTitle());
		}
	}
	public void LoadSampleContent() {
		this.content = "This book bundle, has only {1 book}. The (book itself) - doesn't @belong to the <bundle>,which upsetted me!?";
	}
	public void processContent() {
		for(String token : this.content.split("[\\p{Punct}\\p{Space} && [^\']]+")) {
			if(!contentTokens.contains(token)) {
				contentTokens.add(token);
				wordFrequency.put(token, 1);
			}else {
				wordFrequency.replace(token,wordFrequency.get(token)+1);
			}	
		}
		Collections.sort((List)contentTokens);
	}
	@Override
	public String toString() {
		return "ID: " + this.getId() + "\nTitle: " + this.getTitle() + "\nCategory: " + this.getCategory() + "\nCost: "
				+ this.getCost() + "$\nAuthor(s): " + this.authors.toString() + "\nContent Length: "
				+ contentTokens.size() + " word(s)\nWord Frequency: " + wordFrequency.toString();
	}
}
