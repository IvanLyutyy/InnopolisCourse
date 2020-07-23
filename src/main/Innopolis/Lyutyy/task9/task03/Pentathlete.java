package main.Innopolis.Lyutyy.task9.task03;

public class Pentathlete extends Human {
    public Pentathlete(String name) {
        super(name);
    }

    @Override
    public String run() {
        return "бегает для поддержания формы и спортивных достижений";
    }

    @Override
    public String swim() {
        return "плавает для поддержания формы и спортивных достижений";
    }
}
