package Lyutyy.task9.task03;

public class RunnerAthlete extends Human {
    public RunnerAthlete(String name) {
        super(name);
    }

    @Override
    public String run() {
        return "бегает для спортивных достижений";
    }

    @Override
    public String swim() {
        return "плавает для поддержания формы";
    }
}
