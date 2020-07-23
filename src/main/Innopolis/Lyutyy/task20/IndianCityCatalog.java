package main.Innopolis.Lyutyy.task20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс {@code IndianCityCatalog} даёт возможность получать данные о городах Индии в формате JSON
 * Суть задачи:
 * Есть набор бесплатных сервисов в интернете, предоставляющих данные в формате JSON:
 * https://github.com/toddmotto/public-apis/blob/master/README.md
 * Выбрать любой сервис, какой больше нравится, и написать программу, которая с ним взаимодействует.
 *     Класс сериализуемого объекта может содержать не все поля, а только 2-3 ключевых. Например, для погоды достаточно показать диапазон температур.
 *     Минимальное количество запросов к сервису - 1. Не обязательно реализовывать весь функционал, предоставляемый сервисом. Достаточного одного любого запроса
 * @author Lyutyy Ivan
 */
public class IndianCityCatalog {

    /**
     * Точка входа
     * @param args параметр содержит аргументы командной строки.
     * @throws IOException исключение ввода-вывода, генерируемое методом.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String searchLine = "";
        StringBuilder concatLine = new StringBuilder();

        while (true) {
            System.out.println("");
            System.out.println("Введите № операции (exit для выхода):");
            System.out.println("1 - вывести все города Индии");
            System.out.println("2 - поиск города по названию");
            System.out.println("3 - поиск городов по названию штата");
            System.out.println("4 - поиск городов по названию округа");
            System.out.println("5 - поиск города по части названия");
            System.out.println("6 - поиск городов по части названия штата");
            System.out.println("7 - поиск городов по части названия округа");
            System.out.println("8 - вывести последний сериализованный результат поиска");

            String line = br.readLine();
            if (line.equals("exit")) break;

            switch (line) {
                case "1":
                    System.out.println("Список городов Индии:");
                    IndianCityJsonManager.getIndianCitiesJSON("");
                    break;
                case "2":
                    System.out.println("Введите название города (например: Jaipur):");
                    searchLine = br.readLine();
                    concatLine.setLength(0);
                    searchLine = concatLine.append("?City=").append(searchLine).toString();
                    IndianCityJsonManager.getIndianCitiesJSON(searchLine);
                    break;
                case "3":
                    System.out.println("Введите название штата (например: Goa):");
                    searchLine = br.readLine();
                    concatLine.setLength(0);
                    searchLine = concatLine.append("?State=").append(searchLine).toString();
                    IndianCityJsonManager.getIndianCitiesJSON(searchLine);
                    break;
                case "4":
                    System.out.println("Введите название округа (например: South Goa):");
                    searchLine = br.readLine();
                    concatLine.setLength(0);
                    searchLine = concatLine.append("?District=").append(searchLine).toString();
                    IndianCityJsonManager.getIndianCitiesJSON(searchLine);
                    break;
                case "5":
                    System.out.println("Введите часть названия города (например: New):");
                    searchLine = br.readLine();
                    concatLine.setLength(0);
                    searchLine = concatLine.append("?City_like=").append(searchLine).toString();
                    IndianCityJsonManager.getIndianCitiesJSON(searchLine);
                    break;
                case "6":
                    System.out.println("Введите часть названия штата (например: Kash):");
                    searchLine = br.readLine();
                    concatLine.setLength(0);
                    searchLine = concatLine.append("?State_like=").append(searchLine).toString();
                    IndianCityJsonManager.getIndianCitiesJSON(searchLine);
                    break;
                case "7":
                    System.out.println("Введите часть названия округа (например: West):");
                    searchLine = br.readLine();
                    concatLine.setLength(0);
                    searchLine = concatLine.append("?District_like=").append(searchLine).toString();
                    IndianCityJsonManager.getIndianCitiesJSON(searchLine);
                    break;
                case "8":
                    System.out.println("Результаты последнего поиска:");
                    IndianCityJsonManager.deserializeCatalog();
                    break;
                default:
                    System.out.println("Введён некорректный номер операции");
                    break;
            }
        }
    }
}
