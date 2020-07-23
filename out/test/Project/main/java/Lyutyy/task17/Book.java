package Lyutyy.task17;

import java.io.Serializable;

public class Book implements Serializable {
    private final String author;
    private final String title;
    private final String year;

    public Book(String author, String title, String year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return author + " - " + '\'' + title + '\'' + " (" + year + ")";
    }
}
