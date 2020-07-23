package Lyutyy.task6;

public class Frog extends Animal {
    public Frog() {
    }

    public Frog(String name, String color) {
        super(name, color);
    }

    @Override
    public void voice () {
        System.out.println(super.getName() + " квакает");
    }
}
