package Lyutyy.task9.task03;

public class SwimmerAthlete extends Human {
    public SwimmerAthlete(String name) {
        super(name);
    }

    @Override
    public String run() {
        return "бегает для поддержания формы";
    }

    @Override
    public String swim() {
        return "плавает для спортивных достижений";
    }
}
