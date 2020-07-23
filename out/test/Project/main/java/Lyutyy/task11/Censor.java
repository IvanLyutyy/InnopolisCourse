package Lyutyy.task11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс заменяет в строке все вхождения слова «бяка» на «вырезано цензурой»
 * Суть задачи:
 * Напишите программу которая получает на вход некую строку, после она вызывает метод,
 * заменяющий в строке все вхождения слова «бяка» на «вырезано цензурой» и выводит результат в консоль!
 * @author Savin Vladimir
 */
public class Censor {
    private String inputString;
    private String searchString;
    private String replacementString;
    private String outputString;

    public Censor(String inputString, String searchString, String replacementString) {
        this.inputString = inputString;
        this.searchString = searchString;
        this.replacementString = replacementString;
    }

    public void convertWithMethod() {
        outputString = inputString.replaceAll("(?iu)" + searchString,replacementString);
    }

    public void convertWithPattern() {
        outputString = Pattern.compile(searchString, Pattern.LITERAL |
                Pattern.CASE_INSENSITIVE |
                Pattern.UNICODE_CASE)
                .matcher(inputString)
                .replaceAll(Matcher.quoteReplacement(replacementString));
    }

    @Override
    public String toString() {
        return outputString;
    }

    public static void main(String[] args) {
        Censor censor = new Censor("Меню: кулеБяка с капустой, кулебякА с яблоками, кулебяка с грибами.",
                "бяка","\'вырезано цензурой\'");
        censor.convertWithMethod();
        System.out.println("Замена с replaceAll: " + censor);
        censor.convertWithPattern();
        System.out.println("Замена с Pattern: " + censor);
    }
}
