package Lyutyy.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ZagadannoeChislo, predpolagaemoeChislo;
        Scanner input = new Scanner(System.in);
        System.out.println("Угадать число от 1 до 100");
        ZagadannoeChislo = (int)Math.floor(Math.random() * 100);
        do {
            int OSH =0;

            System.out.print("Введите число:");

            predpolagaemoeChislo = input.nextInt();

            if ( predpolagaemoeChislo > 100)
                System.out.println("Выбираем от 1 до 100!");

            if ( predpolagaemoeChislo < 1)
                System.out.println("Выбираем от 1 до 100!");

            if ( predpolagaemoeChislo == 123)
                break;
            System.out.println("Для выхода напиши 123");

            if ( predpolagaemoeChislo == 0)
                break;

            if ( predpolagaemoeChislo == ZagadannoeChislo)
                System.out.println("Загаданное число:");

            if ( predpolagaemoeChislo > ZagadannoeChislo)
                OSH = predpolagaemoeChislo - ZagadannoeChislo;
            else
                OSH = ZagadannoeChislo - predpolagaemoeChislo;

            if (OSH > 10)
                System.out.println("Холодно");
            else
                System.out.println("Горячо");

        } while ( predpolagaemoeChislo != ZagadannoeChislo);



    }
}
