package Lyutyy.task17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;

public class Library implements Serializable {
    static final Logger log = LogManager.getLogger(Library.class.getName());

    private static final long serialVersionUID = 1L;
    private Book[] books;

    public Library() {
            books = new Book[1];
    }

    public void showBooks() {
        if (books.length == 1 && books[0] == null) {
            log.error("Библиотека пуста. Пожалуйста добавьте книгу или попробуйте восстановить библиотеку");
        } else {
            log.info("Список книг:");
            for (Book book : books) {
                log.info(book);
            }
        }
    }

    public void addBook(Book book) {
        if (books.length == 1 && books[0] == null) {
            books[0] = book;
        } else {
            books = Arrays.copyOf(books, books.length + 1);
            books[books.length - 1] = book;
        }
        log.info("Книга добавлена в библиотеку: {}",book);
    }
}
