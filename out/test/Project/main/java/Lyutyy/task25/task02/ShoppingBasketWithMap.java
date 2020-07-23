package Lyutyy.task25.task02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.savin.homework23.Basket;

import java.util.*;

/**
 * Класс {@code ShoppingBasketWithMap} является реализацией интерфейса {@code Basket}.
 * Методы данного класса реализуют функционал корзины интернет-магазина.
 * @author Savin Vladimir
 */
public class ShoppingBasketWithMap implements Basket {
    static final Logger log = LogManager.getLogger(ShoppingBasketWithMap.class.getName());
    private static final String EMPTY_BASKET = "Корзина пуста. Пожалуйста добавьте товары.";
    private final Map<String, Integer> productsMap;

    public ShoppingBasketWithMap() {
        productsMap = new LinkedHashMap<>();
    }

    public void addProduct(String product, int quantity) {
        if (quantity <= 0) {
            log.error("Нулевое или отрицательное количества товара недопустимо.");

        } else if (!productsMap.containsKey(product.toUpperCase())) {
            productsMap.put(product.toUpperCase(), quantity);
            log.info("Добавлен товар '{}' в количестве {}", product, quantity);

        } else if (productsMap.containsKey(product.toUpperCase())) {
            int productCount = getProductQuantity(product) + quantity;
            updateProductQuantity(product, productCount);
        }
    }

    public void removeProduct(String product) {
        if (productsMap.isEmpty()) {
            log.error(EMPTY_BASKET);

        } else if (!productsMap.containsKey(product.toUpperCase())) {
            log.error("Товар '{}' не найден в корзине.", product);

        } else {
            productsMap.entrySet().removeIf(entries -> entries.getKey().equalsIgnoreCase(product));
            log.info("Товар '{}' удалён из корзины", product);
        }
    }

    public void updateProductQuantity(String product, int quantity) {
        if (productsMap.isEmpty()) {
            log.error(EMPTY_BASKET);

        } else if (quantity <= 0) {
            log.error("Нулевое или отрицательное количества товара недопустимо.");

        } else if (!productsMap.containsKey(product.toUpperCase())) {
            log.error("Товар '{}' не найден в корзине.", product);

        } else {
            int productCount = productsMap.get(product.toUpperCase());

            if (productCount == quantity) {
                log.error("Количество товара '{}' в корзине уже равно {}.", product, quantity);
            } else {
                for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
                    if (product.equalsIgnoreCase(entry.getKey())) {
                        entry.setValue(quantity);
                    }
                }
                log.info("Изменено количество товара '{}' в корзине: {}.", product, quantity);
            }
        }
    }

    public void clear() {
        if (productsMap.isEmpty()) {
            log.error("Корзина уже пуста.");

        } else {
            productsMap.clear();
            log.info("Корзина очищена от товаров.");
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
            log.error(EMPTY_BASKET);

        } else {
            log.info("Товары в корзине:");
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
            log.info(productFormatter);
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
