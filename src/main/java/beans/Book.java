package beans;

import java.util.Comparator;

/**
 * Created by Moe on 3/5/17.
 */
public class Book{

    private String author;
    private String name;
    private int pages;
    private int price;
    public static final Comparator<Book> BY_AUTHOR = (o1, o2) -> o1.author.compareTo(o2.author);
    public static final Comparator<Book> BY_PRICE = (o1, o2) -> new Integer(o1.price).compareTo(o2.price);

    public Book(String author, String name, int pages, int price) {
        this.author = author;
        this.name = name;
        this.pages = pages;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%d", name, author, pages, price);
    }
}
