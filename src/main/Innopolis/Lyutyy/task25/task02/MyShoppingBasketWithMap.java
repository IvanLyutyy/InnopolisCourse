package main.Innopolis.Lyutyy.task25.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyShoppingBasketWithMap} демонстрирует работу с корзиной интернет-магазина.
 * Суть задачи:
 * Реализовать класс корзины интернет магазина по следующему интерфейсу, используя реализацию мапы:
 * interface Basket {
 *     void addProduct(String product, int quantity);
 *     void removeProduct(String product);
 *     void updateProductQuantity(String product, int quantity);
 *     void clear();
 *     List<String> getProducts();
 *     int getProductQuantity(String product);
 * }
 * @author Lyutyy Ivan
 */
public class MyShoppingBasketWithMap {

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        ShoppingBasketWithMap basket = new ShoppingBasketWithMap();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("");
                System.out.println("Введите № операции (exit для выхода):");
                System.out.println("1 - показать товары в корзине");
                System.out.println("2 - добавить товар в корзину");
                System.out.println("3 - изменить количество товара в корзине");
                System.out.println("4 - удалить товар из корзины");
                System.out.println("5 - очистить корзину");

                String line = br.readLine();
                if (line.equals("exit")) return;

                String name = "";
                int count = 0;

                switch (line) {
                    case "1":
                        basket.showProducts(basket.getProducts());
                        break;
                    case "2":
                        System.out.println("Введите наименование товара, который нужно добавить:");
                        name = br.readLine();
                        System.out.println("Введите количество добавляемого товара:");
                        count = Integer.parseInt(br.readLine());
                        basket.addProduct(name, count);
                        break;
                    case "3":
                        System.out.println("Введите наименование товара, количество которого нужно изменить:");
                        name = br.readLine();
                        System.out.println("Введите новое количество товара:");
                        count = Integer.parseInt(br.readLine());
                        basket.updateProductQuantity(name, count);
                        break;
                    case "4":
                        System.out.println("Введите наименование товара, который нужно удалить:");
                        name = br.readLine();
                        basket.removeProduct(name);
                        break;
                    case "5":
                        basket.clear();
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
