package main.Innopolis.Lyutyy.task43;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyLibraryDB} позволяет работать с БД 'Библиотека'.
 * @author Lyutyy Ivan
 */
public class MyLibraryDB {
    static LibraryDB lib = new LibraryDB();

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("");
                System.out.println("Введите № операции (exit для выхода):");
                System.out.println("1 - вывести список книг в наличии");
                System.out.println("2 - вывести список читателей");
                System.out.println("3 - добавить читателя");
                System.out.println("4 - назначить книгу читателю (взять книгу из библиотеки)");
                System.out.println("5 - снять книгу с читателя (вернуть книгу в библиотеку)");
                System.out.println("6 - статистика по книгам: доступно/на руках, автор к общему кол-ву книг");
                System.out.println("7 - поиск книги по автору");
                System.out.println("8 - поиск книги по названию");

                String line = br.readLine();
                if (line.equals("exit")) return;

                int bookNum = 0;
                int readerNum = 0;

                switch (line) {
                    case "1":
                        lib.showBooks();
                        break;
                    case "2":
                        lib.showReaders();
                        break;
                    case "3":
                        System.out.println("Введите имя нового читателя:");
                        String readerName = br.readLine();
                        lib.addReader(readerName);
                        break;
                    case "4":
                        lib.showBooks();
                        System.out.println("");
                        System.out.println("Введите № книги, которую нужно взять в библиотеке:");
                        bookNum = Integer.parseInt(br.readLine());
                        lib.showReaders();
                        System.out.println("");
                        System.out.println("Введите № читателя, которому нужно назначить книгу:");
                        readerNum = Integer.parseInt(br.readLine());
                        lib.takeBook(bookNum, readerNum);
                        break;
                    case "5":
                        lib.showBooks();
                        System.out.println("");
                        System.out.println("Введите № книги, которую нужно вернуть в библиотеку:");
                        bookNum = Integer.parseInt(br.readLine());
                        lib.showReaders();
                        System.out.println("");
                        System.out.println("Введите № читателя, который должен вернуть книгу:");
                        readerNum = Integer.parseInt(br.readLine());
                        lib.returnBook(bookNum, readerNum);
                        break;
                    case "6":
                        lib.getStatistics();
                        break;
                    case "7":
                        System.out.println("Введите автора для поиска книг:");
                        String authorName = br.readLine();
                        lib.searchByAuthor(authorName);
                        break;
                    case "8":
                        System.out.println("Введите название книги для поиска:");
                        String bookTitle = br.readLine();
                        lib.searchByTitle(bookTitle);
                        break;
                    default:
                        System.out.println("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        finally {
            ConnectionDB.closeConnection();
        }
    }
}
