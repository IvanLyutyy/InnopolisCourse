package main.Innopolis.Lyutyy.task17;

import java.io.*;

/**
 * Класс сериализует и десериализует Library
 */
public class LibraryStorage {

    public void saveLibrary(Library library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.dat"))) {
            oos.writeObject(library);
            System.out.println("Библиотека сохранена в library.dat");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода:");
            System.out.println(e.fillInStackTrace());
        }
    }

    public Library loadLibrary() {
        File file = new File("library.dat");
        if (file.exists() && file.isFile()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Library) ois.readObject();
            } catch (IOException e) {
                System.out.println("Ошибка ввода-вывода:");
                System.out.println(e.fillInStackTrace());
            } catch (ClassNotFoundException e) {
                System.out.println("Не найден считываемый класс:");
                System.out.println(e.fillInStackTrace());
            }
        } else {
            System.out.println("Файл сохранения library.dat не найден. Восстановление невозможно");
        }
        return null;
    }
}
