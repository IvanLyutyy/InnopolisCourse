package main.Innopolis.Lyutyy.task13;

public class Child {
    public void tasteDish(Food food) throws ChildDissatisfiedException {
        if (!food.isTasty(food)) {
            throw new ChildDissatisfiedException(food.getFoodName(food) +
                    " - это невкусно! Но спасибо, что не оставили голодным...");
        }

        System.out.println(food.getFoodName(food) + " - это очень вкусно! Спасибо огромное!!!");
    }
}
