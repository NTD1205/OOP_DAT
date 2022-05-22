package AimsProject.hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, List<String> authors) {
        super(title, category);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName))
            System.out.println("Tên tác giả đã có!");
        else
            authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName))
            System.out.println("Không có tác giả này!");
        else
            authors.remove(authorName);
    }

    @Override
    public String toString() {
        return "Sách có tiêu đề \"" + this.getTitle()+"\"";
    }
}
