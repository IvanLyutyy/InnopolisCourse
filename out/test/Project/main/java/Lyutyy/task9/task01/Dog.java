package Lyutyy.task9.task01;

import ru.savin.homework09.task02.Runable;
import ru.savin.homework09.task02.Swimable;

public class Dog extends Animal implements Runable, Swimable {
    @Override
    public void getName() {
        System.out.println("Собака");
    }

    @Override
    public String run() {
        return "Собака бегает";
    }

    @Override
    public String swim() {
        return "Собака плавает";
    }
}
