package Lyutyy.task27;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;

/**
 * Методы класса {@code Fibonacci} выводят ряды Фибоначчи.
 * @author Savin Vladimir
 */
public class Fibonacci {
    static final Logger log = LogManager.getLogger(Fibonacci.class.getName());

    private Fibonacci() {}

    /**
     * Метод возвращает значение ряда Фибоначчи, используя рекурсию.
     * Очень ресурсозатратен, поэтому не рекомендуется передавать значения больше 40 (39).
     * @param n индекс значения ряда (равен n-1, т.к. индексы начинаются с нуля).
     * @return значение ряда по индексу.
     */
    public static long getFibonacciWithRecursion(int n) {
        if (n <= 1) return n;

        return getFibonacciWithRecursion(n-1) + getFibonacciWithRecursion(n-2);
    }

    /**
     * Метод возвращает значение ряда Фибоначчи, используя итерацию.
     * @param n индекс значения ряда (равен n-1, т.к. индексы начинаются с нуля).
     * @return значение ряда по индексу.
     */
    public static BigInteger getFibonacciWithIteration(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger prePreviousValue;
        BigInteger previousValue = BigInteger.ZERO;
        BigInteger nextValue = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            prePreviousValue = previousValue;
            previousValue = nextValue;
            nextValue = prePreviousValue.add(previousValue);
        }

        return nextValue;
    }
}
