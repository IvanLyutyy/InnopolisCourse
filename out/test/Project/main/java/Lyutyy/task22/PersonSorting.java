package Lyutyy.task22;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * @author Savin Vladimir
 */
public class PersonSorting {
    static final Logger log = LogManager.getLogger(PersonSorting.class.getName());

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
                log.info("");
                log.info("Введите № операции (exit для выхода):");
                log.info("1 - показать список персон");
                log.info("2 - добавить персону в список");
                log.info("3 - вывести список персон, отсортированный Суперкомпаратором по возрасту, по имени");
                log.info("4 - вывести список персон, отсортированный по возрасту, по имени");
                log.info("5 - вывести список персон, отсортированный по имени, по возрасту");
                log.info("6 - перемешать список персон");

                String line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        pr.showPersons();
                        break;
                    case "2":
                        log.info("Введите возраст персоны");
                        int age = Integer.parseInt(br.readLine());
                        log.info("Введите имя персоны");
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
                        log.error("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
