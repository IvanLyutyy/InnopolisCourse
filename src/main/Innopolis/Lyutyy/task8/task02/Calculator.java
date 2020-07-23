package main.Innopolis.Lyutyy.task8.task02;

public class Calculator {
    public static int summation(int a, int b) {
        return a + b;
    }

    public static double summation(double a, double b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(int a, int b) {
        if (b == 0) {
            System.out.println("Деление на ноль невозможно!");
            return 0;
        } else {
            return a / b;
        }
    }

    public static double division(double a, double b) {
        if (b == 0) {
            System.out.println("Деление на ноль невозможно!");
            return 0;
        } else {
            return a / b;
        }
    }

    public static double percentage(int a, int b) {
        return (a * 100) / b;
    }

    public static double percentage(double a, double b) {
        return (a * 100) / b;
    }
}
