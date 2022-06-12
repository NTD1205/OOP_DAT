package hust.soict.hedspi.test.book;

import java.io.IOException;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
	public static void main(String args[]) throws IOException {
		Book book = new Book("foo");
		book.LoadSampleContent();
		book.processContent();
		System.out.println(book.toString());
	}
}
