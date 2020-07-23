package main.Innopolis.Lyutyy.task29;

import java.util.Objects;

/**
 * Объект класса {@code Person} хранит данные о персоне:
 * - возраст;
 * - фамилия;
 * - пол.
 * @author Lyutyy Ivan
 */
public class Person {
    private final int age;
    private final String surname;
    private final String sex;

    /**
     * Конструктор класса {@code Person} при создании объекта класса инициализирует поля "возраст", "фамилия" и "пол".
     * @param age передаёт значение для инициализации поля "возраст" создаваемого объекта.
     * @param surname передаёт значение для инициализации поля "фамилия" создаваемого объекта.
     * @param sex передаёт значение для инициализации поля "пол" создаваемого объекта.
     */
    public Person(int age, String surname, String sex) {
        this.age = age;
        this.surname = surname;
        this.sex = sex;
    }

    /**
     * Метод возвращает хранимае объектом {@code Person} значение поля "возраст".
     * @return значения поля "возраст".
     */
    public int getAge() {
        return age;
    }

    /**
     * Метод возвращает хранимае объектом {@code Person} значение поля "фамилия".
     * @return значения поля "фамилия".
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Метод возвращает хранимае объектом {@code Person} значение поля "пол".
     * @return значения поля "пол".
     */
    public String getSex() {
        return sex;
    }

    /**
     * Переопределённый метод сравнивает текущий объект с объектом-параметром по значениям полей.
     * @param o объект, с которым сравнивается текущий объект.
     * @return true - если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(sex, person.sex);
    }

    /**
     * Переопределённый метод вычисляет и возвращает хеш-код текущего объекта.
     * @return хеш-код.
     */
    @Override
    public int hashCode() {
        final int prime = 48;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        return result;
    }

    /**
     * Переопределённый метод возвращает текстовое представление состояния объекта {@code Person}.
     * @return значения полей "фамилия", "возраст" и "пол"
     */
    @Override
    public String toString() {
        return '\'' + surname + "', " + age + ", '" + sex + '\'';
    }
}
