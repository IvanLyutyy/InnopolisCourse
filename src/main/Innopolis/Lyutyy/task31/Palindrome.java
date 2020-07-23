package main.Innopolis.Lyutyy.task31;

/**
 * Класс {@code Palindrome} позволяет проверить строку на палиндром.
 * @author Lyutyy Ivan
 */
public class Palindrome {
    private Palindrome() {}

    /**
     * Метод проверяет строк на палиндром.
     * @param s проверяемая строка.
     * @return true - если палиндром, иначе false;
     */
    public static boolean checkIfPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            char symbol = s.charAt(i);
            int mirrorIndex = s.length() - 1 - i;
            char mirrorSymbol = s.charAt(mirrorIndex);
            if (symbol != mirrorSymbol) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод проверяет строк на палиндром.
     * @param s проверяемая строка.
     * @return true - если палиндром, иначе false;
     */
    public static boolean checkIfPalindromeLazy(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
