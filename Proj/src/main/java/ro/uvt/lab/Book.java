package ro.uvt.lab;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private final List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author a) {
        authors.add(a);
    }

    public void addContent(Element e) {
        add(e);
    }

    @Override
    public void print() {
        System.out.println("Book: " + this.name);
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        printChildren();
    }
}
