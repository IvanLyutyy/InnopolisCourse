package main.Innopolis.Lyutyy.task25.task02;

import main.Innopolis.Lyutyy.task23.Basket;

import java.util.*;

/**
 * Класс {@code ShoppingBasketWithMap} является реализацией интерфейса {@code Basket}.
 * Методы данного класса реализуют функционал корзины интернет-магазина.
 * @author Lyutyy Ivan
 */
public class ShoppingBasketWithMap implements Basket {
    private static final String EMPTY_BASKET = "Корзина пуста. Пожалуйста добавьте товары.";
    private final Map<String, Integer> productsMap;

    public ShoppingBasketWithMap() {
        productsMap = new LinkedHashMap<>();
    }

    public void addProduct(String product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Нулевое или отрицательное количества товара недопустимо.");

        } else if (!productsMap.containsKey(product.toUpperCase())) {
            productsMap.put(product.toUpperCase(), quantity);
            System.out.printf("Добавлен товар '{}' в количестве {}", product, quantity);

        } else if (productsMap.containsKey(product.toUpperCase())) {
            int productCount = getProductQuantity(product) + quantity;
            updateProductQuantity(product, productCount);
        }
    }

    public void removeProduct(String product) {
        if (productsMap.isEmpty()) {
            System.out.println(EMPTY_BASKET);

        } else if (!productsMap.containsKey(product.toUpperCase())) {
            System.out.printf("Товар '{}' не найден в корзине.", product);

        } else {
            productsMap.entrySet().removeIf(entries -> entries.getKey().equalsIgnoreCase(product));
            System.out.printf("Товар '{}' удалён из корзины", product);
        }
    }

    public void updateProductQuantity(String product, int quantity) {
        if (productsMap.isEmpty()) {
            System.out.println(EMPTY_BASKET);

        } else if (quantity <= 0) {
            System.out.println("Нулевое или отрицательное количества товара недопустимо.");

        } else if (!productsMap.containsKey(product.toUpperCase())) {
            System.out.printf("Товар '{}' не найден в корзине.", product);

        } else {
            int productCount = productsMap.get(product.toUpperCase());

            if (productCount == quantity) {
                System.out.printf("Количество товара '{}' в корзине уже равно {}.", product, quantity);
            } else {
                for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
                    if (product.equalsIgnoreCase(entry.getKey())) {
                        entry.setValue(quantity);
                    }
                }
                System.out.printf("Изменено количество товара '{}' в корзине: {}.", product, quantity);
            }
        }
    }

    public void clear() {
        if (productsMap.isEmpty()) {
            System.out.println("Корзина уже пуста.");

        } else {
            productsMap.clear();
            System.out.println("Корзина очищена от товаров.");
        }
    }

    public List<String> getProducts() {
        return new ArrayList<>(productsMap.keySet());
    }

    public int getProductQuantity(String product) {
        if (!productsMap.containsKey(product.toUpperCase())) {
            return 0;
        }
        return productsMap.get(product.toUpperCase());
    }

    /**
     * Метод выводит хранящиеся в корзине товары (наименование и количество) в виде таблицы.
     * @param productsList коллекция, товары которой нужно вывести.
     */
    public void showProducts(List<String> productsList) {
        if (productsList.isEmpty()) {
            System.out.println(EMPTY_BASKET);

        } else {
            System.out.println("Товары в корзине:");
            printProductString("Товар", "Количество");
            printProductString("====================", "==========");

            for (String s : productsList) {
                printProductString(s, String.valueOf(getProductQuantity(s)));
            }
        }
    }

    /**
     * Метод задаёт формат строки выводимого товара (наименования и количества).
     * Также метод выводит строки заголовка столбцов и разделители.
     * @param product наименование выводимого товара.
     * @param count количество выводимого товара.
     */
    public void printProductString(String product, String count) {
        try (Formatter productFormatter = new Formatter()) {
            productFormatter.format("%-20.20s%10.10s", product, count);
            System.out.println(productFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
