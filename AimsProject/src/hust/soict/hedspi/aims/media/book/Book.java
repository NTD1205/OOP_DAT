package hust.soict.hedspi.aims.media.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import hust.soict.hedspi.aims.media.Media;

public class Book extends Media{
	private ArrayList<String> authors = new ArrayList<String>();
	private String content;
	public List<String>contentTokens =  new ArrayList<String>();
	public Map<String, Integer>wordFrequency = new TreeMap<String, Integer>();
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		processContent();
	}

	private void processContent() {
		// split by \\s and convert Array<String> to List<String>
		// add all to contentTokens
		contentTokens.addAll(Arrays.asList(content.split("\\s+")));
		// contentToken has been sorted
		Collections.sort(contentTokens);
		// loop in List contentToken
		Iterator<String> iterator = contentTokens.iterator();
		while(iterator.hasNext()) {
			String string = iterator.next();
			// if don't have key --> put to Map
			// else value++ --> put to Map
			if (wordFrequency.containsKey(string) == false) {
				wordFrequency.put(string, 1);
			}else {
				int a = wordFrequency.get(string);
				a++;
				wordFrequency.put(string, a);
			}
		}
	}
	
	@Override
	public String toString() {
		String string = "";
		string += "Id: " + super.id + "\n";
		string += "Title: "	+ super.title + "\n";
		string += "Category: " + super.category + "\n";
		string += "Cost: " + super.cost + "\n";
		string += "Number of tokens: " + contentTokens.size() + "\n";
		for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
			string += entry.getKey() + " - "+ entry.getValue() + "\n";
		}
		return string;
	}
	
	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

	public Book(String id, String title, float cost) {
		super(id, title, cost);
	}
	
	public Book(String id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public Book(String id, String title, String category, float cost, ArrayList<String> authors) {
		super(id, title, category, cost);
		if(authors.size() != 0) {
			this.authors = authors;
		}else {
			System.out.println("Authors list is empty!");
		}
	}
	
	public void addAuthor(String authorName){
		for(String author: authors) {
			if(author.equalsIgnoreCase(authorName))
				System.err.println("Exist author name");
				return;
		}
		authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		for(String author: authors) {
			if(author.equalsIgnoreCase(authorName))
				authors.remove(author);
				return;
		}
		System.err.println("Don't exist author name");
	}

}
