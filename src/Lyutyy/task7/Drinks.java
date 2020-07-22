package Lyutyy.task7;

public enum Drinks {
    EMPTY("Пусто", 0),
    WATER("Вода", 20.00),
    JUICE("Сок", 90.00),
    TEA("Чай", 50.00),
    COFFEE("Кофе", 100.00);

    private String drinkName;
    private double drinkPrice;

    Drinks(String drinkName, double drinkPrice) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }

    public static double getDrinkPrice(Drinks drink) {
        return drink.drinkPrice;
    }

    @Override
    public String toString() {
        return '\'' + drinkName + '\'' + ", Цена: " + drinkPrice + " руб.";
    }
}
