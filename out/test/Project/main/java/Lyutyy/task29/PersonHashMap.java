package Lyutyy.task29;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Класс {@code PersonHashMap} позволяет удалить дублирующиеся значения карты {@code Map}.
 * @author Savin Vladimir
 */
public class PersonHashMap {
    static final Logger log = LogManager.getLogger(PersonHashMap.class.getName());
    private Map<String, Person> personMap;

    public PersonHashMap() {
        personMap = new HashMap<>();
    }

    /**
     * Метод вызывает {@code createMap} для заполнения карты и получения ссылки на неё.
     */
    public void fillMapWithElements() {
        personMap = createMap();
        log.info("Карта заполнена.");
    }

    /**
     * Метод создаёт карту {@code HashMap} и заполняет её значениями, имеющими дубли.
     * @return ссылка на созданны и заполненны значениями с дублями {@code HashMap}.
     */
    public static Map<String, Person> createMap()
    {
        Map<String, Person> book = new HashMap<>();
        Person person1 = new Person(29,"Петрова","жен");
        Person person2 = new Person(34, "Сидорова", "жен");
        Person person3 = new Person(34, "Тихонова", "жен");
        Person person4 = new Person(35, "Петров", "муж");
        book.put("Key1", person1);
        book.put("Key2", person1);
        book.put("Key3", person2);
        book.put("Key4", person3);
        book.put("Key5", person4);
        book.put("Key6", person4);
        return book;
    }

    /**
     * Метод удаляет из карты все значения, равные переданному в параметре.
     * @param map карта, в которой нужно удалить значения.
     * @param value значение, все экземпляры которого нужно удалить из карты.
     */
    public static void removeItemFromMapByValue(Map<String, Person> map, Person value)
    {
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    /**
     * Метод ищет дублирующиеся значения в карте и вызывает {@code removeItemFromMapByValue}
     * для удаления всех таких экземпляров.
     * @param map карта, в которой нужно найти дубли значений.
     */
    public static void removeTheDuplicates(Map<String, Person> map) {
        HashMap<String, Person> entryMap = new HashMap<>(map);
        HashMap<String, Person> controlMap = new HashMap<>(map);

        for (Map.Entry<String, Person> entry : entryMap.entrySet())
        {
            controlMap.remove(entry.getKey());
            if (controlMap.containsValue(entry.getValue())) {
                removeItemFromMapByValue(map, entry.getValue());
                removeItemFromMapByValue(controlMap, entry.getValue());
            }
        }
    }

    /**
     * Метод вызывает {@code removeTheDuplicates} для поиска и удаления повторяющихся значений карты {@code Map}.
     */
    public void deleteDuplicates() {
        if (personMap.isEmpty()) {
            log.error("Карта пуста. Создайте элементы карты.");
        } else {
            removeTheDuplicates(personMap);
            log.info("Значения карты проверены на дублирование.");
        }
    }

    /**
     * Метод выводит записи карты {@code Map}.
     */
    public void showMap() {
        if (personMap.isEmpty()) {
            log.error("Карта пуста.");
        } else {
            log.info("Карта: {}", personMap);
        }
    }
}
