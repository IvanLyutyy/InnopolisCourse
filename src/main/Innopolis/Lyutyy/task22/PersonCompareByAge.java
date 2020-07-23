package main.Innopolis.Lyutyy.task22;

import java.util.Comparator;

/**
 * Класс {@code PersonCompareByAge} является компаратором для объектов {@code Person} по полю "возраст".
 * @author Lyutyy Ivan
 */
public class PersonCompareByAge implements Comparator<Person> {
    /**
     * Метод возвращает разницу полей "возраст", переданных его параметрам объектов {@code Person}.
     * @param obj1 Передаёт методу первый объект {@code Person}.
     * @param obj2 Передаёт методу второй объект {@code Person}.
     * @return возвращает разницу полей "возраст", переданных методу объектов {@code Person}.
     */
    @Override
    public int compare(Person obj1, Person obj2) {
        return obj1.getAge() - obj2.getAge();
    }
}
