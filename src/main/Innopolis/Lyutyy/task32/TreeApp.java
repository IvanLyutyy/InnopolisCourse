package main.Innopolis.Lyutyy.task32;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code TreeApp} позволяет создать бинарное дерево и поработать с его узлами.
 * Суть задачи:
 * Программа для подсчета листовых узлов в двоичном дереве в Java.
 * @author Lyutyy Ivan
 */
public class TreeApp {

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("");
                System.out.println("Введите № операции (exit для выхода):");
                System.out.println("1 - создать дерево");
                System.out.println("2 - вывести количество узлов");
                System.out.println("3 - вывести узлы префиксным обходом");
                System.out.println("4 - вывести узлы инфиксным обходом");
                System.out.println("5 - вывести узлы постфиксным обходом");
                System.out.println("6 - добавить узел");
                System.out.println("7 - удалить узел");
                System.out.println("8 - очистить дерево");

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
                        System.out.println("Дерево создано.");
                        break;
                    case "2":
                        System.out.printf("Количество узлов в дереве: {}", tree.getNodeCount());
                        break;
                    case "3":
                        System.out.println("Префиксный обход дерева:");
                        tree.printPreOrder();
                        break;
                    case "4":
                        System.out.println("Инфиксный обход дерева:");
                        tree.printInOrder();
                        break;
                    case "5":
                        System.out.println("Постфиксный обход дерева:");
                        tree.printPostOrder();
                        break;
                    case "6":
                        System.out.println("Введите целочисленное значение узла для добавления:");
                        line = br.readLine();
                        tree.add(Integer.parseInt(line));
                        System.out.printf("Узел '{}' добавлен.", line);
                        break;
                    case "7":
                        System.out.println("Введите целочисленное значение узла для удаления:");
                        line = br.readLine();
                        if (!tree.contains(Integer.parseInt(line))) {
                            System.out.printf("Узел '{}' не найден в дереве.", line);
                        } else {
                            tree.remove(Integer.parseInt(line));
                            System.out.printf("Узел '{}' удалён", line);
                        }
                        break;
                    case "8":
                        tree.clearTree();
                        System.out.println("Дерево очищено.");
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
