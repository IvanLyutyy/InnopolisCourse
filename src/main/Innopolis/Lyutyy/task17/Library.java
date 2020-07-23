package main.Innopolis.Lyutyy.task17;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {

    private static final long serialVersionUID = 1L;
    private Book[] books;

    public Library() {
            books = new Book[1];
    }

    public void showBooks() {
        if (books.length == 1 && books[0] == null) {
            System.out.println("Библиотека пуста. Пожалуйста добавьте книгу или попробуйте восстановить библиотеку");
        } else {
            System.out.println("Список книг:");
            for (Book book : books) {
                System.out.println(book);
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
        System.out.printf("Книга добавлена в библиотеку: {}",book);
    }
}
