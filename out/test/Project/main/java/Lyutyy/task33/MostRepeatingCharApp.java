package Lyutyy.task33;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * @author Savin Vladimir
 */
public class MostRepeatingCharApp {
    static final Logger log = LogManager.getLogger(MostRepeatingCharApp.class.getName());

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите строку для поиска самого повторяющегося символа (exit для выхода):");
                String line = br.readLine();
                if (line.equals("exit")) return;

                if (!line.isEmpty()) {
                    getMostRepeatingChar(line);
                } else {
                    log.info("Вы ввели пустую строку.");
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
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
                log.info("Символ '{}' встречается в строке наибольшее количество раз: {}", symbol, max);
            }
        }
    }
}
