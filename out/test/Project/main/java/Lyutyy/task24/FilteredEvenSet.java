package Lyutyy.task24;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code FilteredEvenSet} демонстрирует работу с классом {@code FilteredSet}.
 * Суть задачи:
 * Написать метод, который возвращает множество, в котором удалены все элементы четной длины из исходного множества.
 * public Set<String> removeEvenLength(Set<String> set);
 * Например, для множества ["foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"]
 * метод вернет ["foo", "bar", "spoon", "!"]
 * @author Savin Vladimir
 */
public class FilteredEvenSet {
    static final Logger log = LogManager.getLogger(FilteredEvenSet.class.getName());

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        FilteredSet set = new FilteredSet();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите № операции (exit для выхода):");
                log.info("1 - вывести элементы множества");
                log.info("2 - добавить строку к множеству");
                log.info("3 - фильтровать множество (убрать элементы чётной длины)");
                log.info("4 - очистить множество");

                String line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        set.showSet(set.getStringSet());
                        break;
                    case "2":
                        log.info("Введите строку, которую нужно добавить к множеству:");
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
                        log.error("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
