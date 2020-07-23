package main.Innopolis.Lyutyy.task23;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

/**
 * Класс {@code ShoppingBasket} является реализацией интерфейса {@code Basket}.
 * Методы данного класса реализуют функционал корзины интернет-магазина.
 * @author Lyutyy Ivan
 */
public class ShoppingBasket implements Basket {
    private static final String EMPTY_BASKET = "Корзина пуста. Пожалуйста добавьте товары.";
    private final List<String> productsList;

    public ShoppingBasket() {
        productsList = new ArrayList<>();
    }

    public void addProduct(String product, int quantity) {
        if (containsIgnoreCase(productsList, product)) {
            System.out.printf("Товар '{}' уже добавлен в корзину. Если требуется, то измените его количество.",
                    getProductNameInBasket(productsList, product));

        } else if (quantity <= 0) {
            System.out.println("Нулевое или отрицательное количества товара недопустимо.");

        } else {
            for (int i = 0; i < quantity; i++) {
                productsList.add(product);
            }
            System.out.printf("Добавлен товар '{}' в количестве {}", product, quantity);
        }
    }

    public void removeProduct(String product) {
        if (productsList.isEmpty()) {
            System.out.println(EMPTY_BASKET);

        } else if (!containsIgnoreCase(productsList, product)) {
            System.out.printf("Товар '{}' не найден в корзине.", product);

        } else {
            String productNameInBasket = "";
            Iterator<String> productIterator = productsList.iterator();
            while (productIterator.hasNext()) {
                String prod = productIterator.next();
                if (prod.equalsIgnoreCase(product)) {
                    productNameInBasket = getProductNameInBasket(productsList, product);
                    productIterator.remove();
                }
            }
            System.out.printf("Товар '{}' удалён из корзины", productNameInBasket);
        }
    }

    public void updateProductQuantity(String product, int quantity) {
        if (productsList.isEmpty()) {
            System.out.println(EMPTY_BASKET);

        } else if (quantity <= 0) {
            System.out.println("Нулевое или отрицательное количества товара недопустимо.");

        } else if (!containsIgnoreCase(productsList, product)) {
            System.out.printf("Товар '{}' не найден в корзине.", product);

        } else {
            int productCount = getProductQuantity(product);

            if (productCount < quantity) {
                for (int i = 0; i < quantity - productCount; i++) {
                    productsList.add(getProductNameInBasket(productsList, product));
                }
                System.out.printf("Количество товара '{}' в корзине увеличено до {}.",
                        getProductNameInBasket(productsList, product),
                        quantity);

            } else if (productCount > quantity) {
                int productCountToRemove = productCount - quantity;
                for (Iterator<String> i = productsList.iterator(); i.hasNext() && productCountToRemove > 0;) {
                    String prod = i.next();
                    if (prod.equalsIgnoreCase(product)) {
                        i.remove();
                        productCountToRemove--;
                    }
                }
                System.out.printf("Количество товара '{}' в корзине уменьшено до {}.",
                        getProductNameInBasket(productsList, product),
                        quantity);

            } else {
                System.out.printf("Количество товара '{}' в корзине уже равно {}.",
                        getProductNameInBasket(productsList, product),
                        quantity);
            }
        }
    }

    public void clear() {
        if (productsList.isEmpty()) {
            System.out.println("Корзина уже пуста.");
        } else {
            productsList.clear();
            System.out.println("Корзина очищена от товаров.");
        }
    }

    public List<String> getProducts() {
        return productsList;
    }

    public int getProductQuantity(String product) {
        if (!containsIgnoreCase(productsList, product)) {
            return 0;
        }
        int productCount = 0;
        for (String s : productsList) {
            if (s.equalsIgnoreCase(product)) {
                productCount++;
            }
        }
        return productCount;
    }

    /**
     * Метод проверяет наличие в коллекции указанного товара, независимо от того,
     * в каком регистре введены буквы наименования этого товара.
     * @param productsList коллекция, в которой проверяется наличие товара.
     * @param product наименование товара, наличие которого проверяется указанной в коллекции.
     * @return true, если товар найден в указанной коллекции; false, если товар в указанной коллекции не найден.
     */
    public boolean containsIgnoreCase(List<String> productsList, String product) {
        for (String s : productsList) {
            if (s.equalsIgnoreCase(product)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает наименование товара в том регистре, в каком он хранится в указанной коллекции.
     * @param productsList коллекция, из которой извлекается наименование указанного товара.
     * @param product товар, для которого из коллекции нужно извлечь хранящееся наименование.
     * @return наименование товара в регистре, в котором он хранится в указанной коллекции.
     */
    public String getProductNameInBasket(List<String> productsList, String product) {
        for (String s : productsList) {
            if (s.equalsIgnoreCase(product)) {
                return s;
            }
        }
        return "";
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
            List<String> products = new ArrayList<>();
            for (String s : productsList) {
                if (!containsIgnoreCase(products, s)) {
                    products.add(s);
                    printProductString(s, String.valueOf(getProductQuantity(s)));
                }
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
