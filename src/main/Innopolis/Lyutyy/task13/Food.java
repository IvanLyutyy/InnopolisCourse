package main.Innopolis.Lyutyy.task13;

public enum Food {
    CARROT("Морковь",false),
    APPLE("Яблоко",true),
    PORRIDGE("Каша",false),
    SAUSAGE("Сосиска",true),
    SOUP("Суп",false),
    PANCAKES("Блинчики",true);

    private String foodName;
    private boolean isTasty;

    Food(String foodName, boolean isTasty) {
        this.foodName = foodName;
        this.isTasty = isTasty;
    }

    public String getFoodName(Food food) {
        return foodName;
    }

    public boolean isTasty(Food food) {
        return isTasty;
    }
}
