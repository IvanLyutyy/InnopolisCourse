package main.Innopolis.Lyutyy.task19;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Класс выводит кассовый чек, используя данные файла в определённом формате:
 * Название товара
 * количество
 * цена
 */
public class CashReceipt {
    private CashReceipt() {}

    public static void printReceiptFromFile(String fileName) {
        File file = new File(fileName);
        try (Scanner sc = new Scanner(file)) {
            // Выводим заголовок чека
            printReceiptString("%-16s%8s   %s%15s", "Наименование", "Цена", "Кол-во", "Стоимость");
            String cashReceiptDelimiter = "================================================";
            printReceiptString(cashReceiptDelimiter);

            // Выводим тело чека
            String name = "";
            String sCost = "";
            BigDecimal bdCount = new BigDecimal("0");
            BigDecimal bdPrice = new BigDecimal("0");
            BigDecimal bdCost = new BigDecimal("0");
            BigDecimal bdTotalCost = new BigDecimal("0");
            int lineCounter = 1;

            while (sc.hasNextLine()) {
                switch (lineCounter) {
                    case 1:
                        name = sc.nextLine();
                        lineCounter++;
                        break;
                    case 2:
                        bdCount = BigDecimal.valueOf(Double.parseDouble(sc.nextLine())).setScale(3, RoundingMode.HALF_UP);
                        lineCounter++;
                        break;
                    case 3:
                        bdPrice = BigDecimal.valueOf(Double.parseDouble(sc.nextLine())).setScale(2, RoundingMode.HALF_UP);
                        bdCost = bdCount.multiply(bdPrice).setScale(2, RoundingMode.HALF_UP);
                        sCost = "=" + String.format("%.2f", bdCost);
                        bdTotalCost = bdTotalCost.add(bdCost).setScale(2, RoundingMode.HALF_UP);

                        printReceiptString("%-16.16s%8.2f x %6.3f%15s", name, bdPrice, bdCount, sCost);
                        lineCounter = 1;
                        break;
                    default:
                        break;
                }
            }

            // Выводим итог по чеку
            printReceiptString(cashReceiptDelimiter);
            printReceiptString("%-6.6s%42.2f", "Всего:", bdTotalCost.setScale(2, RoundingMode.HALF_UP));
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void printReceiptString(String cashReceiptString) {
        System.out.println(cashReceiptString);
    }

    public static void printReceiptString(String pattern, String name, String price, String count, String cost) {
        try (Formatter cashReceiptFormatter = new Formatter()) {
            cashReceiptFormatter.format(pattern, name, price, count, cost);
            System.out.println(cashReceiptFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void printReceiptString(String pattern,
                                          String name, BigDecimal price, BigDecimal count, String cost) {
        try (Formatter cashReceiptFormatter = new Formatter()) {
            cashReceiptFormatter.format(pattern, name, price, count, cost);
            System.out.println(cashReceiptFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void printReceiptString(String pattern, String totalString, BigDecimal totalCost) {
        try (Formatter cashReceiptFormatter = new Formatter()) {
            cashReceiptFormatter.format(pattern, totalString, totalCost);
            System.out.println(cashReceiptFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
