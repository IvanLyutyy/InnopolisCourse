package main.Innopolis.Lyutyy.task9.task01;

import main.Innopolis.Lyutyy.task9.task02.Swimable;

public class Fish extends Animal implements Swimable {
    @Override
    public void getName() {
        System.out.println("Рыба");
    }

    @Override
    public String swim() {
        return "Рыба плавает";
    }
}
