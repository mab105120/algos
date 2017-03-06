package beans;

import java.util.Comparator;

/**
 * Created by Moe on 3/5/17.
 */
public class Book{

    private String author;
    private String name;
    private int pages;
    private double price;
    private final Comparator<Book> BY_AUTHOR = (o1, o2) -> o1.author.compareTo(o2.author);
    private final Comparator<Book> BY_PRICE = (o1, o2) -> new Double(o1.price).compareTo(o2.price);

    public Book(String author, String name, int pages, double price) {
        this.author = author;
        this.name = name;
        this.pages = pages;
        this.price = price;
    }
}
