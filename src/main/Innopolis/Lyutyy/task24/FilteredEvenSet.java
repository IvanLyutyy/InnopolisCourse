package main.Innopolis.Lyutyy.task24;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code FilteredEvenSet} демонстрирует работу с классом {@code FilteredSet}.
 * Суть задачи:
 * Написать метод, который возвращает множество, в котором удалены все элементы четной длины из исходного множества.
 * public Set<String> removeEvenLength(Set<String> set);
 * Например, для множества ["foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"]
 * метод вернет ["foo", "bar", "spoon", "!"]
 * @author Lyutyy Ivan
 */
public class FilteredEvenSet {

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        FilteredSet set = new FilteredSet();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("");
                System.out.println("Введите № операции (exit для выхода):");
                System.out.println("1 - вывести элементы множества");
                System.out.println("2 - добавить строку к множеству");
                System.out.println("3 - фильтровать множество (убрать элементы чётной длины)");
                System.out.println("4 - очистить множество");

                String line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        set.showSet(set.getStringSet());
                        break;
                    case "2":
                        System.out.println("Введите строку, которую нужно добавить к множеству:");
                        line = br.readLine();
                        set.addString(line);
                        break;
                    case "3":
                        set.showSet(set.removeEvenLength(set.getStringSet()));
                        break;
                    case "4":
                        set.clearSet();
                        break;
                    default:
                        System.out.println("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
