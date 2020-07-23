package Lyutyy.task22;

import java.util.Comparator;

/**
 * Класс {@code PersonCompareByName} является компаратором для объектов {@code Person} по полю "имя".
 * @author Savin Vladimir
 */
public class PersonCompareByName implements Comparator<Person> {
    /**
     * Метод сравнивает значения полей "имя", переденных ему объектов {@code Person}.
     * @param obj1 Передаёт методу первый объект {@code Person}.
     * @param obj2 Передаёт методу второй объект {@code Person}.
     * @return возвращает результат сравнения полей "имя", переданных методу объектов {@code Person}.
     */
    @Override
    public int compare(Person obj1, Person obj2) {
        return obj1.getName().compareTo(obj2.getName());
    }
}
