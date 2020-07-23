package main.Innopolis.Lyutyy.task7;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс имитирует автомат по продаже напитков
 * Суть задачи:
 * Реализовать программу «Вендинговый автомат», которая позволит:
 *     Посмотреть меню напитков
 *     Внести деньги на внутренний счет
 *     Выбрать номер напитка и получить его, если на счету достаточно средств.
 * Программа должна обрабатывать следующие ситуации:
 *     Пользователь не внес деньги
 *     Пользователь выбрал более дорогой напиток, чем внесено денег
 *     Пользователь выбрал несуществующий номер напитка
 * Для хранения напитков предлагается использовать массив с enum. У напитка должна быть цена и название.
 * Homework14:
 * Добавить в программу "Вендинговый автомат" журналирование событий, при этом стоит указать
 * различные уровни логирования, как информационного уровня, так и предупреждения и ошибки.
 * Настроить сбор логов в файл.
 * Фреймворк логирования - на ваш выбор.
 * @author Lyutyy Ivan
 */
public class DrinkBox {
    public static void main(String[] args) throws IOException {
        VendingMachine vm = new VendingMachine();
        System.out.println("--------------------------------------------------");
        vm.showContent();
        System.out.println("");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isNotBought = true; // Признак - пока товар не куплен
        boolean isNeedToAddMoney = true;
        boolean isCanToChooseDrink = false;
        double cash;
        int productIndex;

        while (isNotBought) {
            if (isNeedToAddMoney) {
                System.out.println("Добавьте деньги для покупки:");
                cash = Double.parseDouble(reader.readLine());
                vm.addMoney(cash);
                if (vm.getCountOfMoney() > 0) {
                    System.out.printf("В автомате: {} руб.",vm.getCountOfMoney());
                    isNeedToAddMoney = false;
                    isCanToChooseDrink = true;
                } else {
                    System.out.printf("Денег в автомате недостаточно: {} руб.",vm.getCountOfMoney());
                    isNeedToAddMoney = true;
                    isCanToChooseDrink = false;
                }
            }

            if (isCanToChooseDrink) {
                System.out.println("Выберите номер напитка для покупки:");
                productIndex = Integer.parseInt(reader.readLine());
                if (vm.checkIfCorrectProductIndex(productIndex)) {
                    if (vm.checkIfMoneyEnoughToBuyProduct(productIndex)) {
                        vm.getProduct(productIndex);
                        if (vm.getCountOfMoney() > 0) {
                            System.out.printf("Ваша сдача: {} руб.",vm.getCountOfMoney());
                        }
                        isNotBought = false;
                    } else {
                        isNeedToAddMoney = true;
                        isCanToChooseDrink = false;
                    }
                } else {
                    System.out.println("Введён некорректный номер напитка!");
                    System.out.println("");
                    vm.showContent();
                }
            }
        }
        System.out.println("Спасибо, что воспользовались автоматом!");
    }
}
