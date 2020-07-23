package Lyutyy.task9.task03;

import ru.savin.homework09.task02.Runable;
import ru.savin.homework09.task02.Swimable;

public abstract class Human implements Runable, Swimable {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String run();

    public abstract String swim();
}
