package Lyutyy.task21.task02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code ReversedArray} имеет ряд методов для работы с данными одномерного целочисленного массива.
 *
 * @author Savin Vladimir
 */
public class ReversedArray {
    static final Logger log = LogManager.getLogger(ReversedArray.class.getName());

    private ReversedArray() {}

    /**
     * Метод инициализирует одномерный целочисленный массив.
     * @param array содержит одномерный целочисленный массив.
     */
    public static void initializeArray(int[] array) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < array.length; i++) {
                log.info("Введите {}й элемент (целое число):", i + 1);
                int arrayElement = Integer.parseInt(br.readLine());
                array[i] = arrayElement;
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }

    /**
     * Метод зеркально меняет местами элементы исходного одномерного целочисленного массива из параметра {@param array}.
     * Т.е. первый элемент массива меняется местами с последним элементом и так далее.
     * Метод работает с чётным и нечётным количеством элементов в массиве.
     * @param array содержит одномерный целочисленный массив.
     */
    public static void reverseArray(int[] array) {
        try {
            for (int i = 0; i < array.length / 2; i++) {
                int mirrorIndex = array.length - 1 - i;
                int mirrorElement = array[mirrorIndex];
                array[mirrorIndex] = array[i];
                array[i] = mirrorElement;
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }

    /**
     * Метод выводит элементы одномерного целочисленного массива.
     * @param array содержит одномерный целочисленный массив.
     */
    public static void printArray(int[] array) {
        try {
            StringBuilder arrayLine = new StringBuilder();

            for (int i : array) {
                arrayLine.append(i).append('\t');
            }
            log.info(arrayLine);
            arrayLine.setLength(0);
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
