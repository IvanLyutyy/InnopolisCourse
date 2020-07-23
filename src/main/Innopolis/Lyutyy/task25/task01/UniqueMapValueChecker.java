package main.Innopolis.Lyutyy.task25.task01;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Класс {@code UniqueMapValueChecker} проверяет наличие одинаковых значений в {@code Map}.
 * @author Lyutyy Ivan
 */
public class UniqueMapValueChecker {
    private final Map<String, String> stringMap;

    public UniqueMapValueChecker() {
        stringMap = new LinkedHashMap<>();
    }

    /**
     * Метод добавляет элемент в {@code Map}.
     * @param key ключ добавляемого элемента {@code Map}.
     * @param value значение добавляемого элемента {@code Map}.
     */
    public void addPair(String key, String value) {
        stringMap.put(key, value);
        System.out.printf("Запись ('{}', '{}') добавлена.", key, value);
    }

    /**
     * Метод обрабатывает значение, которое вернул метод {@code isUnique}
     * и выводит соответствующие сообщения.
     */
    public void checkUniqueValues() {
        if (stringMap.isEmpty()) {
            System.out.println("Карта пуста. Добавьте элементы.");
        } else {
            if (isUnique(stringMap)) {
                System.out.println("Карта не содержит дубли значений.");
            } else {
                System.out.println("Карта содержит дубли значений.");
            }
        }
    }

    /**
     * Метод проверяет значения {@code Map} на дубли.
     * @param map коллекция {@code Map}, среди значений которой происходит поиск дублей.
     * @return true - дублей нет, иначе false.
     */
    public boolean isUnique(Map<String, String> map) {
        Set<String> valuesSet = new HashSet<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!valuesSet.add(entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Метод обрабатывает значение, которое вернул метод {@code isUniqueLazy}
     * и выводит соответствующие сообщения.
     */
    public void checkUniqueValuesLazy() {
        if (stringMap.isEmpty()) {
            System.out.println("Карта пуста. Добавьте элементы.");
        } else {
            if (isUniqueLazy(stringMap)) {
                System.out.println("Карта не содержит дубли значений.");
            } else {
                System.out.println("Карта содержит дубли значений.");
            }
        }
    }

    /**
     * Метод проверяет значения {@code Map} на дубли.
     * @param map коллекция {@code Map}, среди значений которой происходит поиск дублей.
     * @return true - дублей нет, иначе false.
     */
    public boolean isUniqueLazy(Map<String, String> map) {
        Set<String> valuesSet = new HashSet<>(map.values());

        return map.size() == valuesSet.size();
    }

    /**
     * Метод выводит записи карты {@code Map}.
     */
    public void showMap() {
        if (stringMap.isEmpty()) {
            System.out.println("Карта пуста.");
        } else {
            System.out.printf("Карта: {}", stringMap);
        }
    }

    /**
     * Метод очищает карту {@code Map} от записей.
     */
    public void clearMap() {
        if (stringMap.isEmpty()) {
            System.out.println("Карта уже пуста.");
        } else {
            stringMap.clear();
            System.out.println("Карта очищена.");
        }
    }
}
