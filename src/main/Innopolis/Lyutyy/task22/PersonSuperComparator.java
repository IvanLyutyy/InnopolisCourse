package main.Innopolis.Lyutyy.task22;

import java.util.Comparator;

public class PersonSuperComparator implements Comparator<Person> {
    /**
     * Метод сравнивает значения полей "возраст" и "имя" переденных ему объектов {@code Person}.
     * @param obj1 Передаёт методу первый объект {@code Person}.
     * @param obj2 Передаёт методу второй объект {@code Person}.
     * @return возвращает результат сравнения полей "возраст" и "имя", переданных методу объектов {@code Person}.
     */
    @Override
    public int compare(Person obj1, Person obj2) {
        int comparison = 0;
        comparison = obj1.getAge() - obj2.getAge();
        if (comparison == 0) {
            comparison =  obj1.getName().compareTo(obj2.getName());
        }
        return comparison;
    }
}
