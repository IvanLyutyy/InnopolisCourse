package main.Innopolis.Lyutyy.task29;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyDuplicateMap} позволяет добавить записи в карту {@code Map},
 * проверить значения на дубли и удалить их.
 * Суть задачи:
 * Создать хешмап для класса Person (поля - возраст , фамилия,  пол) - переопределить equals(), hashСode(),
 * toString() для объектов класса Person.
 * Добавить в мапу элементы так, что внутри мапы с разными ключами окажутся одинаковые Person
 * public static Map<String, Person> createMap() {
 *   Map<String, Person> book = new HashMap<>();
 *   Person person1 = new Person(29,"Петрова","жен");
 *   Person person2 = new Person(34, "Сидорова", "жен");
 *   Person person3 = new Person(34, "Тихонова", "жен");
 *   Person person4 = new Person(35, "Петров", "муж");
 *   book.put("Key1", person1);
 *   book.put("Key2", person1);
 *   book.put("Key3", person2);
 *   book.put("Key4", person3);
 *   book.put("Key5", person4);
 *   book.put("Key6", person4);
 *   return book;
 * }
 * Реализовать метод removeTheDuplicates по поиску дубликатов в исходной мапе, затем при нахождении дубликата
 * удалить его из исходной мапы используя метод
 * removeItemFromMapByValue(Map<String, Person> map, Person value)
 * public static void removeTheDuplicates(Map<String, Person> map){}
 * public static void removeItemFromMapByValue(Map<String, Person> map, Person value) {
 *   Map<String, Person> copy = new HashMap<>(map);
 *   for (Map.Entry<String, Person> pair: copy.entrySet()) {
 *     if (pair.getValue().equals(value))
 *       map.remove(pair.getKey());
 *   }
 * }
 *  Вывести содержимое мапы в консоль.
 * @author Lyutyy Ivan
 */
public class MyDuplicateMap {

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        PersonHashMap map = new PersonHashMap();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("");
                System.out.println("Введите № операции (exit для выхода):");
                System.out.println("1 - создать элементы карты");
                System.out.println("2 - проверить значения карты на дубли");
                System.out.println("3 - вывести элементы карты");

                String line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        map.fillMapWithElements();
                        break;
                    case "2":
                        map.deleteDuplicates();
                        break;
                    case "3":
                        map.showMap();
                        break;
                    default:
                        System.out.println("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
