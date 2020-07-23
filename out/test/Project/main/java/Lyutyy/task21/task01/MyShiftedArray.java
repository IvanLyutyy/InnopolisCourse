package Lyutyy.task21.task01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyShiftedArray} реализует следующую задачу:
 * Суть задачи:
 * Дан двумерный массив типа:
 *      [[1, 2, 3, 4, 5]
 *       [6, 7, 8, 9]
 *       [10, 11, 12]]
 * Нужно:
 *      1.Пройти с 1-ой до последней строки
 *      2.Пройти с 1-го до предпоследнего элемента
 *      3.В текущую ячейку поместить значение следующей
 *      4.Последнему элементу присвоить 0
 * Чтобы получился массив типа
 *      [[2, 3, 4, 5, 0]
 *       [7, 8, 9, 0]
 *       [11, 12, 0]]
 * @author Savin Vladimir
 */
public class MyShiftedArray {
    static final Logger log = LogManager.getLogger(MyShiftedArray.class.getName());

    /**
     * Точка входа
     * @param args параметр содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            log.info("Введите количество строк создаваемого двумерного целочисленного массива (exit для выхода):");
            String line = br.readLine();
            if (line.equals("exit")) return;
            int stringsCount = Integer.parseInt(line);

            int[][] twoDimensionalIntArray = new int[stringsCount][];

            ShiftedArray.initializeTwoDimensionalArray(twoDimensionalIntArray);
            log.info("Исходный массив:");
            ShiftedArray.printTwoDimensionalArray(twoDimensionalIntArray);

            ShiftedArray.shiftTwoDimensionalArray(twoDimensionalIntArray);

            log.info("Обработанный массив:");
            ShiftedArray.printTwoDimensionalArray(twoDimensionalIntArray);
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
