package main.Innopolis.Lyutyy.task9.task01;

import main.Innopolis.Lyutyy.task9.task02.*;
import main.Innopolis.Lyutyy.task9.task03.*;

/**
 * Суть задачи:
 * 1. Написать абстрактный класс Animal с абстрактным методом getName. Сделать несколько классов животных,
 * наследников Animal. Метод getName должен выводит название каждого животного.
 * 2. Написать интерфейсы Fly, Run и Swim чтобы в каждом было по одному методу. Добавить классам животных
 * из предыдущего задания имплементацию этих интерфейсов. Некоторые животные могут реализовать
 * больше одного интерфейса (утка может и плавать, и летать и бегать).
 * 3. Написать абстрактный класс Человек реализующий интерфейсы «бежать» и «плавать» (в каждом сделать 1-2 метода).
 * Сделать несколько наследников этого класса с конкретной реализацией методов, которые объявлены в интерфейсах.
 * @author Lyutyy Ivan
 */
public class Main {
    public static void main(String[] args) {
        // task01
        Dog dog = new Dog();
        dog.getName();
        Duck duck = new Duck();
        duck.getName();
        Fish fish = new Fish();
        fish.getName();
        System.out.println();

        // task02
        Flyable[] fly = {new Duck()};
        String flyers = "Летающие животные: ";
        for (int i = 0; i < fly.length; i++) {
            flyers += fly[i].fly();
            if (i < fly.length - 1) flyers += ", ";
        }
        System.out.println(flyers);

        Runable[] run = {new Dog(), new Duck()};
        String runners = "Бегающие животные: ";
        for (int i = 0; i < run.length; i++) {
            runners += run[i].run();
            if (i < run.length - 1) runners += ", ";
        }
        System.out.println(runners);

        Swimable[] swim = {new Duck(), new Fish()};
        String swimmers = "Плавающие животные: ";
        for (int i = 0; i < swim.length; i++) {
            swimmers += swim[i].swim();
            if (i < swim.length - 1) swimmers += ", ";
        }
        System.out.println(swimmers);
        System.out.println();

        // task03
        Human[] athlete = {new RunnerAthlete("Бегун"),
                new SwimmerAthlete("Пловец"),
                new Pentathlete("Пятиборец")
        };
        for (int i = 0; i < athlete.length; i++) {
            System.out.println(athlete[i].getName() + " " + athlete[i].run() + ", " + athlete[i].swim());
        }
    }
}
