package Lyutyy.task9.task01;

import ru.savin.homework09.task02.Flyable;
import ru.savin.homework09.task02.Runable;
import ru.savin.homework09.task02.Swimable;

public class Duck extends Animal implements Flyable, Runable, Swimable {
    @Override
    public void getName() {
        System.out.println("Утка");
    }

    @Override
    public String fly() {
        return "Утка летает";
    }

    @Override
    public String run() {
        return "Утка бегает";
    }

    @Override
    public String swim() {
        return "Утка плавает";
    }
}
