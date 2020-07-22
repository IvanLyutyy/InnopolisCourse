package Lyutyy.task6;

/**
 * Класс имитирует пруд, заселённый животными
 * Суть задачи:
 * Используя полученные знания об объектно-ориентированном программировании смоделировать какую-нибудь
 * предметную область.
 * Например: банк, университет, библиотека, склад, магазин, пруд и т.д.
 * Ограничения:
 *     Минимум 3 класса
 *     Наличие нескольких полей и методов
 *     Использование модификаторов доступа
 *     Использование принципов ООП
 * @author Ivan Lyutyy
 */
public class Pond {

    public static void main(String[] args) {
        Animal frog = new Frog("Обыкновенная квакша", "зелёный");
        System.out.println("В пруду водится лягушка: " + frog.getName());
        frog.voice();
        System.out.println("Цвет кожи: " + frog.getColor());
        System.out.println("");

        Animal duck = new Duck("Кряква", "серый");
        System.out.println("В пруду водится утка: " + duck.getName());
        duck.voice();
        System.out.println("Цвет перьев: " + duck.getColor());
        System.out.println("");

        Animal fish = new Fish("Карась", "серебристый");
        System.out.println("В пруду водится рыба: " + fish.getName());
        fish.voice();
        System.out.println("Цвет чешуи: " + fish.getColor());
    }
}
