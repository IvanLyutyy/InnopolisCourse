package Lyutyy.task43;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyLibraryDB} позволяет работать с БД 'Библиотека'.
 * @author Savin Vladimir
 */
public class MyLibraryDB {
    static final Logger log = LogManager.getLogger(MyLibraryDB.class.getName());
    static LibraryDB lib = new LibraryDB();

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите № операции (exit для выхода):");
                log.info("1 - вывести список книг в наличии");
                log.info("2 - вывести список читателей");
                log.info("3 - добавить читателя");
                log.info("4 - назначить книгу читателю (взять книгу из библиотеки)");
                log.info("5 - снять книгу с читателя (вернуть книгу в библиотеку)");
                log.info("6 - статистика по книгам: доступно/на руках, автор к общему кол-ву книг");
                log.info("7 - поиск книги по автору");
                log.info("8 - поиск книги по названию");

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
                        log.info("Введите имя нового читателя:");
                        String readerName = br.readLine();
                        lib.addReader(readerName);
                        break;
                    case "4":
                        lib.showBooks();
                        log.info("");
                        log.info("Введите № книги, которую нужно взять в библиотеке:");
                        bookNum = Integer.parseInt(br.readLine());
                        lib.showReaders();
                        log.info("");
                        log.info("Введите № читателя, которому нужно назначить книгу:");
                        readerNum = Integer.parseInt(br.readLine());
                        lib.takeBook(bookNum, readerNum);
                        break;
                    case "5":
                        lib.showBooks();
                        log.info("");
                        log.info("Введите № книги, которую нужно вернуть в библиотеку:");
                        bookNum = Integer.parseInt(br.readLine());
                        lib.showReaders();
                        log.info("");
                        log.info("Введите № читателя, который должен вернуть книгу:");
                        readerNum = Integer.parseInt(br.readLine());
                        lib.returnBook(bookNum, readerNum);
                        break;
                    case "6":
                        lib.getStatistics();
                        break;
                    case "7":
                        log.info("Введите автора для поиска книг:");
                        String authorName = br.readLine();
                        lib.searchByAuthor(authorName);
                        break;
                    case "8":
                        log.info("Введите название книги для поиска:");
                        String bookTitle = br.readLine();
                        lib.searchByTitle(bookTitle);
                        break;
                    default:
                        log.error("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        finally {
            ConnectionDB.closeConnection();
        }
    }
}
