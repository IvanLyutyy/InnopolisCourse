package Lyutyy.task25.task01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyMapValueChecker} позволяет добавить записи в карту {@code Map} и проверить значения на дубли.
 * Суть задачи:
 * public boolean isUnique(Map<String, String> map);
 * Написать метод, который возвращает true, если в мапе нет двух и более одинаковых value, и false в противном случае.
 * Для пустой мапы метод возвращает true.
 * Например, для метода {Вася=Иванов, Петр=Петров, Виктор=Сидоров, Сергей=Савельев, Вадим=Викторов} метод вернет true,
 * а для {Вася=Иванов, Петр=Петров, Виктор=Иванов, Сергей=Савельев, Вадим=Петров} метод вернет false.
 * @author Savin Vladimir
 */
public class MyMapValueChecker {
    static final Logger log = LogManager.getLogger(MyMapValueChecker.class.getName());

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        UniqueMapValueChecker map = new UniqueMapValueChecker();

        String key = "";
        String value = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите № операции (exit для выхода):");
                log.info("1 - вывести элементы карты");
                log.info("2 - добавить элемент карты");
                log.info("3 - проверить значения на дубли (способ №1)");
                log.info("4 - проверить значения на дубли (способ №2)");
                log.info("5 - очистить карту");

                String line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        map.showMap();
                        break;
                    case "2":
                        log.info("Введите ключ:");
                        key = br.readLine();
                        log.info("Введите значение:");
                        value = br.readLine();
                        map.addPair(key, value);
                        break;
                    case "3":
                        map.checkUniqueValues();
                        break;
                    case "4":
                        map.checkUniqueValuesLazy();
                        break;
                    case "5":
                        map.clearMap();
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
