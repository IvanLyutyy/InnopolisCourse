package Lyutyy.task17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс имитирует работу с библиотекой, хранящей книги
 * Суть задачи:
 * Есть набор объектов типа "Книга". Каждая книга имеет название, автора, год издания. Можно больше, по желанию.
 * Программа должна уметь:
 *     добавлять книгу в библиотеку.
 *     показывать список книг в библиотеке.
 *     восстанавливать содержимое библиотеки после перезапуска.
 *     показывать соответствующее сообщение в случае ошибок.
 * Важно!
 *     потоки обязательно должны закрываться
 *     отсутствие файла на диске - не ошибка, а частный случай пустой библиотеки
 * @author Savin Vladimir
 */
public class MyLibrary {
    static final Logger log = LogManager.getLogger(MyLibrary.class.getName());

    public static void main(String[] args) throws IOException {
        Library lib = new Library();
        LibraryStorage ls = new LibraryStorage();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            log.info("");
            log.info("Введите № операции (exit для выхода):");
            log.info("1 - показать список книг в библиотеке");
            log.info("2 - добавить книгу в библиотеку");
            log.info("3 - восстановить сохранённую библиотеку");
            log.info("4 - сохранить библиотеку");
            String line = br.readLine();
            if (line.equals("exit")) break;

            switch (line) {
                case "1":
                    lib.showBooks();
                    break;
                case "2":
                    log.info("Введите автора книги");
                    String author = br.readLine();
                    log.info("Введите название книги");
                    String title = br.readLine();
                    log.info("Введите год(ы) издания книги");
                    String year = br.readLine();
                    lib.addBook(new Book(author,title,year));
                    break;
                case "3":
                    if (ls.loadLibrary() != null) {
                        lib = ls.loadLibrary();
                        log.info("Сохранённая библиотека восстановлена");
                    }
                    break;
                case "4":
                    ls.saveLibrary(lib);
                    break;
                default:
                    log.error("Введён некорректный номер операции");
                    break;
            }
        }

        //lib.addBook(new Book("Носов Н.Н.","Незнайка на Луне","1964-1965"));
        //lib.addBook(new Book("Пушкин А.С.","Руслан и Людмила","1817-1820"));
        //lib.addBook(new Book("Ершов П.П.","Конёк-Горбунок","1834"));
    }
}
