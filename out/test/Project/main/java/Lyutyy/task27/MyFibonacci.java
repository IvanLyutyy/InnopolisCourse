package Lyutyy.task27;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * @author Savin Vladimir
 */
public class MyFibonacci {
    static final Logger log = LogManager.getLogger(MyFibonacci.class.getName());

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите № операции (exit для выхода):");
                log.info("1 - последовательность Фибоначчи с рекурсией");
                log.info("2 - последовательность Фибоначчи с итерацией");

                String line = br.readLine();
                if (line.equals("exit")) return;

                int step = 0;
                StringBuilder sb = new StringBuilder();

                switch (line) {
                    case "1":
                        log.info("ВНИМАНИЕ!!! алгоритм очень ресурсозатратный (лучше не вводить числа больше 40).");
                        log.info("Введите n-й член последовательности Фибоначчи:");
                        step = Integer.parseInt(br.readLine());
                        sb.setLength(0);
                        for (int i = 0; i < step; i++) {
                            sb.append(Fibonacci.getFibonacciWithRecursion(i)).append(' ');
                        }
                        log.info("Ряд из {} элементов: {}", step, sb.toString());
                        break;
                    case "2":
                        log.info("Введите n-й член последовательности Фибоначчи:");
                        step = Integer.parseInt(br.readLine());
                        sb.setLength(0);
                        for (int i = 0; i < step; i++) {
                            sb.append(Fibonacci.getFibonacciWithIteration(i)).append(' ');
                        }
                        log.info("Ряд из {} элементов: {}", step, sb.toString());
                        break;
                    default:
                        log.error("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
