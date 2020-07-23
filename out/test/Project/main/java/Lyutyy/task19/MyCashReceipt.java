package Lyutyy.task19;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Суть задачи:
 * Дан текстовый файл определенной структуры, в котором содержится информация о покупках.
 * Формат файла:
 * Название товара
 * количество
 * цена
 * Необходимо написать программу, которая выведет на экран чек, сформированный из этого файла.
 * В чеке должна быть информация:
 * название товара:  цена Х кол-во = стоимость
 * В конце отчета вывести итоговую стоимость.
 * @author Savin Vladimir
 */
public class MyCashReceipt {
    static final Logger log = LogManager.getLogger(MyCashReceipt.class.getName());

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            log.info("");
            log.info("Введите имя файла (можно с полным путём) по данным которого нужно вывести чек:");

            String line = br.readLine();
            CashReceipt.printReceiptFromFile(line);
        } catch (IOException e) {
            MyCashReceipt.log.error(e.fillInStackTrace());
        }
    }
}
