package main.Innopolis.Lyutyy.task17;

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
 * @author Lyutyy Ivan
 */
public class MyLibrary {

    public static void main(String[] args) throws IOException {
        Library lib = new Library();
        LibraryStorage ls = new LibraryStorage();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("");
            System.out.println("Введите № операции (exit для выхода):");
            System.out.println("1 - показать список книг в библиотеке");
            System.out.println("2 - добавить книгу в библиотеку");
            System.out.println("3 - восстановить сохранённую библиотеку");
            System.out.println("4 - сохранить библиотеку");
            String line = br.readLine();
            if (line.equals("exit")) break;

            switch (line) {
                case "1":
                    lib.showBooks();
                    break;
                case "2":
                    System.out.println("Введите автора книги");
                    String author = br.readLine();
                    System.out.println("Введите название книги");
                    String title = br.readLine();
                    System.out.println("Введите год(ы) издания книги");
                    String year = br.readLine();
                    lib.addBook(new Book(author,title,year));
                    break;
                case "3":
                    if (ls.loadLibrary() != null) {
                        lib = ls.loadLibrary();
                        System.out.println("Сохранённая библиотека восстановлена");
                    }
                    break;
                case "4":
                    ls.saveLibrary(lib);
                    break;
                default:
                    System.out.println("Введён некорректный номер операции");
                    break;
            }
        }
    }
}
