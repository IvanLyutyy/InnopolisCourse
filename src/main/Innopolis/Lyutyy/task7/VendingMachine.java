package main.Innopolis.Lyutyy.task7;

import static main.Innopolis.Lyutyy.task7.Drinks.*;

public class VendingMachine {
    private double money = 0;
    private final Drinks[] drinks;

    public VendingMachine() {
        drinks = new Drinks[] {WATER, JUICE, TEA, COFFEE, WATER};
    }

    public void showContent() {
        for (int i = 0; i < drinks.length; i++) {
            System.out.printf("Товар № {} - {}",i,drinks[i]);
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
            System.out.printf("Внесено недостаточно денег: {} руб.",money);
            return false;
        } else {
            return true;
        }
    }

    public void getProduct(int productIndex) {
        money -= Drinks.getDrinkPrice(drinks[productIndex]);
        System.out.printf("Куплен товар № {} - {}",productIndex,drinks[productIndex]);
        drinks[productIndex] = EMPTY;
    }
}
