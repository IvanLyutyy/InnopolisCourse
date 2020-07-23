package main.Innopolis.Lyutyy.task27;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyFibonacci} демонстрирует вывод рядов Фибоначчи.
 * Суть задачи:
 * Ряд Фибоначчи - это числовой ряд, в котором следующее число является суммой двух предыдущих чисел.
 * Например :
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 и т. д.
 * Есть два способа напечатать серии Фибоначчи.
 *     Используя итерацию
 *     Использование рекурсии
 * Ваша задача реализовать оба способа.
 * @author Lyutyy Ivan
 */
public class MyFibonacci {

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("");
                System.out.println("Введите № операции (exit для выхода):");
                System.out.println("1 - последовательность Фибоначчи с рекурсией");
                System.out.println("2 - последовательность Фибоначчи с итерацией");

                String line = br.readLine();
                if (line.equals("exit")) return;

                int step = 0;
                StringBuilder sb = new StringBuilder();

                switch (line) {
                    case "1":
                        System.out.println("ВНИМАНИЕ!!! алгоритм очень ресурсозатратный (лучше не вводить числа больше 40).");
                        System.out.println("Введите n-й член последовательности Фибоначчи:");
                        step = Integer.parseInt(br.readLine());
                        sb.setLength(0);
                        for (int i = 0; i < step; i++) {
                            sb.append(Fibonacci.getFibonacciWithRecursion(i)).append(' ');
                        }
                        System.out.printf("Ряд из {} элементов: {}", step, sb.toString());
                        break;
                    case "2":
                        System.out.println("Введите n-й член последовательности Фибоначчи:");
                        step = Integer.parseInt(br.readLine());
                        sb.setLength(0);
                        for (int i = 0; i < step; i++) {
                            sb.append(Fibonacci.getFibonacciWithIteration(i)).append(' ');
                        }
                        System.out.printf("Ряд из {} элементов: {}", step, sb.toString());
                        break;
                    default:
                        System.out.println("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
