package main.Innopolis.Lyutyy.task24;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Методы класса {@code FilteredSet} работают с множеством {@code LinkedHashSet<E>}, хранящим строки.
 * @author Lyutyy Ivan
 */
public class FilteredSet {
    private final Set<String> stringSet;

    public FilteredSet() {
        stringSet = new LinkedHashSet<>();
    }

    /**
     * Метод добавляет указанную строку к множеству, если множество ещё не содержит это строки.
     * @param newString новая строка для добавление к элементам множества.
     */
    public void addString(String newString) {
        if (!stringSet.contains(newString)) {
            if (stringSet.add(newString)) {
                System.out.printf("Строка '{}' добавлена к множеству", newString);
            }
        } else {
            System.out.printf("Строка '{}' не была добавлена, т.к. множество её уже содержит.", newString);
        }
    }

    /**
     * Метод фильтрует множество: удаляет строки чётной длины.
     * @param set множество, элементы которого нужно отфильтровать.
     * @return отфильтрованное множество.
     */
    public Set<String> removeEvenLength(Set<String> set) {
        if (!stringSet.isEmpty()) {
            for (Iterator<String> i = stringSet.iterator(); i.hasNext();) {
                if ((i.next().length() % 2) == 0) {
                    i.remove();
                }
            }
            System.out.println("Отфильтрованное множество:");
        }
        return set;
    }

    /**
     * Метод возвращает множество строк {@code LinkedHashSet<E>}.
     * @return множество строк {@code LinkedHashSet<E>}.
     */
    public Set<String> getStringSet() {
        return stringSet;
    }

    /**
     * Метод выводит элементы множества.
     * @param set множество строк {@code LinkedHashSet<E>}.
     */
    public void showSet(Set<String> set) {
        if (set.isEmpty()) {
            System.out.println("Множество не содержит элементов.");
        } else {
            System.out.println("Элементы множества:");
            for (String s : set) {
                System.out.println(s);
            }
        }
    }

    /**
     * Метод полностью очищает множество от хранящихся в нём строк.
     */
    public void clearSet() {
        if (stringSet.isEmpty()) {
            System.out.println("Множество не содержит элементов.");
        } else {
            stringSet.clear();
            System.out.println("Множество очищено от элементов.");
        }
    }
}
