package Lyutyy.task21.task02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyReversedArray} реализует следующую задачу:
 * Суть задачи:
 * Имеется массив, нужно переставить элементы массива в обратном порядке.
 * Задачу не засчитывать если использованы утильные методы класса Arrays.
 * Решением также не являются манупуляции с выводом массива. Необходимо действительно перемещать элементы.
 * Вывести массив в консоль до и после вызова метода по реверсу массива
 * @author Savin Vladimir
 */
public class MyReversedArray {
    static final Logger log = LogManager.getLogger(MyReversedArray.class.getName());

    /**
     * Точка входа
     * @param args параметр содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            log.info("Введите количество элементов создаваемого целочисленного массива (exit для выхода):");
            String line = br.readLine();
            if (line.equals("exit")) return;
            int elementsCount = Integer.parseInt(line);

            int[] intArray = new int[elementsCount];

            ReversedArray.initializeArray(intArray);
            log.info("Исходный массив:");
            ReversedArray.printArray(intArray);

            ReversedArray.reverseArray(intArray);

            log.info("Обработанный массив:");
            ReversedArray.printArray(intArray);
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
