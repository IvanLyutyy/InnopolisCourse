package Lyutyy.task8.task03;

/**
 * Суть задачи:
 * 3. Реализовать класс в конструкторе которого будет счетчик количества создаваемых объектов.
 * Написать метод для получения информации о количестве.
 * @author Savin Vladimir
 */
public class Main {
    public static void main(String[] args) {
        ObjectCounter oc;

        for (int i = 1; i <= 5; i++) {
            oc = new ObjectCounter();
        }

        System.out.println("Создано объектов ObjectCounter: " + ObjectCounter.getObjectCount());
    }
}
