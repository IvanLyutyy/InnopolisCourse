package main.Innopolis.Lyutyy.task22;

/**
 * Объект класса {@code Person} хранит данные о персоне:
 * - возраст;
 * - имя.
 * @author Lyutyy Ivan
 */
public class Person {
    private final int age;
    private final String name;

    /**
     * Конструктор класса {@code Person} при создании объекта класса инициализирует поля "возраст" и "имя".
     * @param age передаёт значение для инициализации поля "возраст" создаваемого объекта.
     * @param name передаёт значения для инициализации поля "имя" создаваемого объекта.
     */
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /**
     * Метод возвращает хранимае объектом {@code Person} значение поля "возраст".
     * @return значения поля "возраст".
     */
    public int getAge() {
        return age;
    }

    /**
     * Метод возвращает хранимае объектом {@code Person} значение поля "имя".
     * @return значение поля "имя".
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает текстовое представление состояния объекта {@code Person}.
     * @return значения полей "возраст" и "имя"
     */
    @Override
    public String toString() {
        return "Возраст: " + age + ", Имя: '" + name + '\'';
    }
}
