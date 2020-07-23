package Lyutyy.task32;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code TreeApp} позволяет создать бинарное дерево и поработать с его узлами.
 * Суть задачи:
 * Программа для подсчета листовых узлов в двоичном дереве в Java.
 * @author Savin Vladimir
 */
public class TreeApp {
    static final Logger log = LogManager.getLogger(TreeApp.class.getName());

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите № операции (exit для выхода):");
                log.info("1 - создать дерево");
                log.info("2 - вывести количество узлов");
                log.info("3 - вывести узлы префиксным обходом");
                log.info("4 - вывести узлы инфиксным обходом");
                log.info("5 - вывести узлы постфиксным обходом");
                log.info("6 - добавить узел");
                log.info("7 - удалить узел");
                log.info("8 - очистить дерево");

                String line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        /*    40
                            /    \
                          20      60
                         /  \    /  \
                        10  30  50   70 */
                        tree.add(40);
                        tree.add(20);
                        tree.add(10);
                        tree.add(30);
                        tree.add(60);
                        tree.add(50);
                        tree.add(70);
                        log.info("Дерево создано.");
                        break;
                    case "2":
                        log.info("Количество узлов в дереве: {}", tree.getNodeCount());
                        break;
                    case "3":
                        log.info("Префиксный обход дерева:");
                        tree.printPreOrder();
                        break;
                    case "4":
                        log.info("Инфиксный обход дерева:");
                        tree.printInOrder();
                        break;
                    case "5":
                        log.info("Постфиксный обход дерева:");
                        tree.printPostOrder();
                        break;
                    case "6":
                        log.info("Введите целочисленное значение узла для добавления:");
                        line = br.readLine();
                        tree.add(Integer.parseInt(line));
                        log.info("Узел '{}' добавлен.", line);
                        break;
                    case "7":
                        log.info("Введите целочисленное значение узла для удаления:");
                        line = br.readLine();
                        if (!tree.contains(Integer.parseInt(line))) {
                            log.error("Узел '{}' не найден в дереве.", line);
                        } else {
                            tree.remove(Integer.parseInt(line));
                            log.info("Узел '{}' удалён", line);
                        }
                        break;
                    case "8":
                        tree.clearTree();
                        log.info("Дерево очищено.");
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
