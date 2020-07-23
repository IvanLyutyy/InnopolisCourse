package main.Innopolis.Lyutyy.task8.task01;

/**
 * Суть задачи:
 * 1. Поэксперементировать с ключевым словом final
 * @author Lyutyy Ivan
 */
public final class FinalExperiment {
    final static double PI = 3.14;

    protected void showPi() {
        System.out.println("Число Pi: " + PI);
    }

    public static void main(String[] args) {
        final int standartAtmosphericPressure = 101325;

        //standartAtmosphericPressure = 100000;   // Ошибка - нельзя изменить final переменную
        System.out.println("Стандартное атмосферное давление (Па): " + standartAtmosphericPressure);

        //FinalExperiment.PI = 3.15;              // Ошибка - нельзя изменить константу
        FinalExperiment fi = new FinalExperiment();
        fi.showPi();
    }
}


class Parent {
    final void showMessage() {
        System.out.println("Суперкласс Parent");
    }
}


//class Child extends FinalExperiment {}    // Ошибка - нельзя наследовать от final класса
class Child extends Parent {
    //@Override
    //void showMessage() {}                 // Ошибка - нельзя переопределять final метод

    void showMessageChild() {
        System.out.println("Производный класс Child");
    }
}