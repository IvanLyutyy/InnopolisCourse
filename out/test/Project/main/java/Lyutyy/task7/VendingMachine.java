package Lyutyy.task7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static ru.savin.homework07.Drinks.*;

public class VendingMachine {
    static final Logger log = LogManager.getLogger(VendingMachine.class.getName());
    private double money = 0;
    private final Drinks[] drinks;

    public VendingMachine() {
        drinks = new Drinks[] {WATER, JUICE, TEA, COFFEE, WATER};
    }

    public void showContent() {
        for (int i = 0; i < drinks.length; i++) {
            log.info("Товар № {} - {}",i,drinks[i]);
        }
    }

    public double getCountOfMoney() {
        return money;
    }

    public void addMoney(double money) {
        if (money > 0)
            this.money += money;
    }

    public boolean checkIfCorrectProductIndex(int productIndex) {
            if (productIndex >= 0 && productIndex <= drinks.length - 1) {
                return true;
            } else {
                return false;
            }
    }

    public boolean checkIfMoneyEnoughToBuyProduct(int productIndex) {
        if (money < Drinks.getDrinkPrice(drinks[productIndex])) {
            log.error("Внесено недостаточно денег: {} руб.",money);
            return false;
        } else {
            return true;
        }
    }

    public void getProduct(int productIndex) {
        money -= Drinks.getDrinkPrice(drinks[productIndex]);
        log.info("Куплен товар № {} - {}",productIndex,drinks[productIndex]);
        drinks[productIndex] = EMPTY;
    }
}
