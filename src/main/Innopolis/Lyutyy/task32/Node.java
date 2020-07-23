package main.Innopolis.Lyutyy.task32;

/**
 * Класс {@code Node} представляет собой узел бинарного дерева, хранящего целочисленные значения.
 * @author Lyutyy Ivan
 */
public class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
