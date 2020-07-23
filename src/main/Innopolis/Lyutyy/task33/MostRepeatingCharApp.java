package main.Innopolis.Lyutyy.task33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс {@code MostRepeatingCharApp} позволяет найти в строке самый часто встречающийся символ.
 * Суть задачи:
 * Вывести максимально встречающийся символ в строке.
 * Пример:
 * This is test message
 * Character: s has occurred maximum times in String: 5
 * @author SLyutyy Ivan
 */
public class MostRepeatingCharApp {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("");
                System.out.println("Введите строку для поиска самого повторяющегося символа (exit для выхода):");
                String line = br.readLine();
                if (line.equals("exit")) return;

                if (!line.isEmpty()) {
                    getMostRepeatingChar(line);
                } else {
                    System.out.println("Вы ввели пустую строку.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод ищет в строке символ, который встречается наибольшее количество раз.
     * @param s строка для поиска самого часто встречающегося символа.
     */
    public static void getMostRepeatingChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char symbol = 0;
        Integer count = 0;
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            symbol = s.charAt(i);
            count = map.get(symbol);
            if (count != null) {
                map.put(symbol, ++count);
                if (count > max) {
                    max = count;
                }
            } else {
                map.put(symbol, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                symbol = entry.getKey();
                System.out.printf("Символ '{}' встречается в строке наибольшее количество раз: {}", symbol, max);
            }
        }
    }
}
