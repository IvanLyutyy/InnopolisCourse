package Lyutyy.task30;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code FirstUniqueCharApp} позволяет вывести первый неповторяющийся символ в строке.
 * Например, первый неповторяющийся символ в «total» равен «o»,
 * а первый неповторяющийся символ в «teter» равен «r».
 * Суть задачи:
 * Напишите программу для поиска первого неповторяющегося символа в строке. Например, первый неповторяющийся символ
 * в «total» равен «o», а первый неповторяющийся символ в «teter» равен «r».
 * @author Savin Vladimir
 */
public class FirstUniqueCharApp {
    static final Logger log = LogManager.getLogger(FirstUniqueCharApp.class.getName());

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите строку для поиска первого неповторяющегося символа (exit для выхода):");
                String line = br.readLine();
                if (line.equals("exit")) return;

                String str = line;
                char ch = 0;

                log.info("Введите № операции (exit для выхода):");
                log.info("1 - менее ленивый способ");
                log.info("2 - более ленивый способ");
                line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        ch = getFirstUniqueChar(str);
                        break;
                    case "2":
                        ch = getFirstUniqueCharLazy(str);
                        break;
                    default:
                        log.error("Введён некорректный номер операции");
                        break;
                }

                if (line.equals("1") || line.equals("2")) {
                    if (ch != 0) {
                        log.info("Первый неповторяющися символ в строке: {}", ch);
                    } else {
                        log.info("Строка не содержит уникальных символов");
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }

    /**
     * Метод выводит первый неповторяющися символ в строке.
     * @param s строка для поиска символа.
     * @return найденный символ, иначе 0 (ноль).
     */
    public static char getFirstUniqueChar(String s) {
        char ch = 0;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (s.indexOf(ch) == i && s.indexOf(ch, i + 1) == -1) {
                return ch;
            }
        }
        return ch;
    }

    /**
     * Метод выводит первый неповторяющися символ в строке.
     * @param s строка для поиска символа.
     * @return найденный символ, иначе 0 (ноль).
     */
    public static char getFirstUniqueCharLazy(String s) {
        char ch = 0;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return ch;
            }
        }
        return ch;
    }
}
