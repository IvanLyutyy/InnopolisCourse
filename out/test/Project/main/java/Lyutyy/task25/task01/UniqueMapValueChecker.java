package Lyutyy.task25.task01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Класс {@code UniqueMapValueChecker} проверяет наличие одинаковых значений в {@code Map}.
 * @author Savin Vladimir
 */
public class UniqueMapValueChecker {
    static final Logger log = LogManager.getLogger(UniqueMapValueChecker.class.getName());
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
        log.info("Запись ('{}', '{}') добавлена.", key, value);
    }

    /**
     * Метод обрабатывает значение, которое вернул метод {@code isUnique}
     * и выводит соответствующие сообщения.
     */
    public void checkUniqueValues() {
        if (stringMap.isEmpty()) {
            log.error("Карта пуста. Добавьте элементы.");
        } else {
            if (isUnique(stringMap)) {
                log.info("Карта не содержит дубли значений.");
            } else {
                log.error("Карта содержит дубли значений.");
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
            log.error("Карта пуста. Добавьте элементы.");
        } else {
            if (isUniqueLazy(stringMap)) {
                log.info("Карта не содержит дубли значений.");
            } else {
                log.error("Карта содержит дубли значений.");
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
            log.error("Карта пуста.");
        } else {
            log.info("Карта: {}", stringMap);
        }
    }

    /**
     * Метод очищает карту {@code Map} от записей.
     */
    public void clearMap() {
        if (stringMap.isEmpty()) {
            log.error("Карта уже пуста.");
        } else {
            stringMap.clear();
            log.info("Карта очищена.");
        }
    }
}
