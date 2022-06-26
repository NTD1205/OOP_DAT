package hust.soict.hedspi.test.book;

import hust.soict.hedspi.aims.media.book.Book;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("a123", "laksd", 712);
		b1.setContent("hello nguyen kahc   thang minh ten la thang   hello thang\n nguyen");
		System.out.println(b1.getContent());
		System.out.println(b1.contentTokens);
		System.out.println(b1.wordFrequency);
		System.out.println("========================================");
		System.out.println(b1.toString());
	}

}
