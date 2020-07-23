package main.Innopolis.Lyutyy.task6;

public class Fish extends Animal {
    public Fish() {
    }

    public Fish(String name, String color) {
        super(name, color);
    }

    @Override
    public void voice () {
        System.out.println(super.getName() + " молчит");
    }
}
