package Lyutyy.task31;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code PalindromeApp} предоставляет возможность проверить строку на палиндром двумя способами.
 * Суть задачи:
 * Палиндром - это слово, фраза, число или другая последовательность символов или элементов, которая читает то же самое вперед или назад.
 * Например: 12121 - палиндром, так как он читает то же самое вперед или назад. мадам тоже палиндром.
 * Требуется написать 2 реализации проверки строки на палиндром:
 *     Перемещение с обоих концов строки одновременно
 *     Используя стандартные функции строки
 * @author Savin Vladimir
 */
public class PalindromeApp {
    static final Logger log = LogManager.getLogger(PalindromeApp.class.getName());

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите строку для проверки на палиндром (exit для выхода):");
                String line = br.readLine();
                if (line.equals("exit")) return;

                String str = line;

                log.info("Введите № операции (exit для выхода):");
                log.info("1 - менее ленивый способ");
                log.info("2 - более ленивый способ");
                line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        if (Palindrome.checkIfPalindrome(str)) {
                            log.info("Строка '{}' палиндром.", str);
                        } else {
                            log.error("Строка '{}' не палиндром.", str);
                        }
                        break;
                    case "2":
                        if (Palindrome.checkIfPalindromeLazy(str)) {
                            log.info("Строка '{}' палиндром.", str);
                        } else {
                            log.error("Строка '{}' не палиндром.", str);
                        }
                        break;
                    default:
                        log.error("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
