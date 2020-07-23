package Lyutyy.task22;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * Класс {@code PersonRegistry} представляет список персон. Хранит список объектов {@code Person}
 * и предоставляет ряд методов для работы со списком персон.
 * @author Savin Vladimir
 */
public class PersonRegistry {
    static final Logger log = LogManager.getLogger(PersonRegistry.class.getName());
    private static final String EMPTY_PERSONS = "Список персон пуст. Пожалуйста добавьте персону.";
    private final Random random = SecureRandom.getInstanceStrong();
    private Person[] persons;

    public PersonRegistry() throws NoSuchAlgorithmException {
        persons = new Person[1];
    }

    /**
     * Метод выводит список персон - объектов {@code Person}, хранящихся классом {@code PersonRegistry}.
     */
    public void showPersons() {
        if (persons.length == 1 && persons[0] == null) {
            log.error(EMPTY_PERSONS);
        } else {
            log.info("Список персон:");
            for (Person person : persons) {
                log.info(person);
            }
        }
    }

    /**
     * Метод добавляет в список персон объект класса {@code Person}.
     * @param person передаёт ссылку на объект класса {@code Person}.
     */
    public void addPerson(Person person) {
        if (persons.length == 1 && persons[0] == null) {
            persons[0] = person;
        } else {
            persons = Arrays.copyOf(persons, persons.length + 1);
            persons[persons.length - 1] = person;
        }
        log.info("Персона добавлена в список: {}", person);
    }

    /**
     * Метод сортирует хранящиеся в списке персон объекты класса {@code Person} одним компаратором
     * сначала по значениям поля "возраст", затем по значениям поля "имя"
     * при помощи классов-компараторов {@code PersonCompareByAge} и {@code PersonCompareByName}.
     */
    public void sortPersonWithSuperComparator() {
        if (persons.length == 1 && persons[0] == null) {
            log.error(EMPTY_PERSONS);
        } else {
            log.info("Список персон отсортирован по возрасту, по имени.");
            Arrays.sort(persons, new PersonSuperComparator());
            showPersons();
        }
    }

    /**
     * Метод сортирует хранящиеся в списке персон объекты класса {@code Person}
     * сначала по значениям поля "возраст", затем по значениям поля "имя"
     * при помощи классов-компараторов {@code PersonCompareByAge} и {@code PersonCompareByName}.
     */
    public void sortPersonByAgeByName() {
        if (persons.length == 1 && persons[0] == null) {
            log.error(EMPTY_PERSONS);
        } else {
            log.info("Список персон отсортирован по возрасту, по имени.");
            Arrays.sort(persons, new PersonCompareByAge().thenComparing(new PersonCompareByName()));
            showPersons();
        }
    }

    /**
     * Метод сортирует хранящиеся в списке персон объекты класса {@code Person}
     * сначала по значениям поля "имя", затем по значениям поля "возраст"
     * при помощи классов-компараторов {@code PersonCompareByName} и {@code PersonCompareByAge}.
     */
    public void sortPersonByNameByAge() {
        if (persons.length == 1 && persons[0] == null) {
            log.error(EMPTY_PERSONS);
        } else {
            log.info("Список персон отсортирован по имени, по возрасту.");
            Arrays.sort(persons, new PersonCompareByName().thenComparing(new PersonCompareByAge()));
            showPersons();
        }
    }

    /**
     * Метод перемешивает список персон - меняет порядок хранящихся объектов класса {@code Person}.
     */
    public void shufflePersons() {
        if (persons.length == 1 && persons[0] == null) {
            log.error(EMPTY_PERSONS);
        } else {
            int randomIndex;
            Person randomPerson;
            for (int i = persons.length - 1; i > 0; i--) {
                randomIndex = random.nextInt(i + 1);
                randomPerson = persons[randomIndex];
                persons[randomIndex] = persons[i];
                persons[i] = randomPerson;
            }
            log.info("Список персон перемешан.");
            showPersons();
        }
    }
}
