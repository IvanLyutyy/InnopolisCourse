package main.Innopolis.Lyutyy.task22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

/**
 * Класс {@code PersonSorting} демонстрирует работу со списком персон, позволяя:
 * - выводить список добавленных персон;
 * - добавлять персону в список персон;
 * - сортировать список сначала по возрасту, затем по имени;
 * - сортировать список сначала по имени, затем по возрасту;
 * - перемешать персоны в списке персон.
 * Суть задачи:
 * Написать класс PersonSuperComparator,
 * который имплементит Comparator, но умеет сравнивать по двум параметрам , возраст и имя.
 * Класс Person теперь содержит два поля int age и String name
 * @author Lyutyy Ivan
 */
public class PersonSorting {

    /**
     * Точка входа
     * @param args параметр содержит аргументы командной строки.
     * @throws IOException исключение ввода-вывода, генерируемое методом.
     * @throws NoSuchAlgorithmException исключение недоступности некого криптографического алгоритма в среде.
     */
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        PersonRegistry pr = new PersonRegistry();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("");
                System.out.println("Введите № операции (exit для выхода):");
                System.out.println("1 - показать список персон");
                System.out.println("2 - добавить персону в список");
                System.out.println("3 - вывести список персон, отсортированный Суперкомпаратором по возрасту, по имени");
                System.out.println("4 - вывести список персон, отсортированный по возрасту, по имени");
                System.out.println("5 - вывести список персон, отсортированный по имени, по возрасту");
                System.out.println("6 - перемешать список персон");

                String line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        pr.showPersons();
                        break;
                    case "2":
                        System.out.println("Введите возраст персоны");
                        int age = Integer.parseInt(br.readLine());
                        System.out.println("Введите имя персоны");
                        String name = br.readLine();
                        pr.addPerson(new Person(age, name));
                        break;
                    case "3":
                        pr.sortPersonWithSuperComparator();
                        break;
                    case "4":
                        pr.sortPersonByAgeByName();
                        break;
                    case "5":
                        pr.sortPersonByNameByAge();
                        break;
                    case "6":
                        pr.shufflePersons();
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
