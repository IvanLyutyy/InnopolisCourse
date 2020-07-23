package Lyutyy.task21.task01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code ShiftedArray} имеет ряд методов для работы с данными двумерного целочисленного массива,
 * при этом массив может быть несимметричным (т.е. строки могут быть разно длины).
 *
 * @author Savin Vladimir
 */
public class ShiftedArray {
    static final Logger log = LogManager.getLogger(ShiftedArray.class.getName());

    private ShiftedArray() {}

    /**
     * Метод инициализирует двумерный целочисленный массив (может быть несимметричным).
     * При этом нужно задать количество элементов для каждой строки.
     * @param twoDimensionalArray содержит двумерный целочисленный массив.
     */
    public static void initializeTwoDimensionalArray(int[][] twoDimensionalArray) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < twoDimensionalArray.length; i++) {
                log.info("Количество элементов {}й строки двумерного целочисленного массива: ", i + 1);
                int elementsCount = Integer.parseInt(br.readLine());
                twoDimensionalArray[i] = new int[elementsCount];

                for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                    log.info("{}й элемент {}й строки (целое число):", j + 1, i + 1);
                    int arrayElement = Integer.parseInt(br.readLine());
                    twoDimensionalArray[i][j] = arrayElement;
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }

    /**
     * Метод проходит по значениям каждо строки двумерного целочисленного массива,
     * сдвигая значения строк влево на один индекс. Последнему элементу массива присваивается ноль.
     * @param twoDimensionalArray содержит двумерный целочисленный массив.
     */
    public static void shiftTwoDimensionalArray(int[][] twoDimensionalArray) {
        try {
            for (int i = 0; i < twoDimensionalArray.length; i++) {
                for (int j = 0; j < twoDimensionalArray[i].length - 1; j++) {
                    twoDimensionalArray[i][j] = twoDimensionalArray[i][j + 1];
                    if (j == twoDimensionalArray[i].length - 2) {
                        twoDimensionalArray[i][j + 1] = 0;
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }

    /**
     * Метод выводит построчно элементы двумерного целочисленного массива.
     * @param twoDimensionalArray содержит двумерный целочисленный массив.
     */
    public static void printTwoDimensionalArray(int[][] twoDimensionalArray) {
        try {
            StringBuilder arrayLine = new StringBuilder();

            for (int[] line : twoDimensionalArray) {
                for (int i : line) {
                    arrayLine.append(i).append('\t');
                }
                log.info(arrayLine);
                arrayLine.setLength(0);
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
