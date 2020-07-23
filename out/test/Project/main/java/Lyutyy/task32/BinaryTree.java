package Lyutyy.task32;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс {@code BinaryTree} представляет собой бинарное дерево поиска.
 * @author Savin Vladimir
 */
public class BinaryTree {
    static final Logger log = LogManager.getLogger(BinaryTree.class.getName());

    private Node root;
    private int nodeCount;

    public BinaryTree() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Метод возвращает количество узлов бинарного дерева.
     * @return количество узлов бинарного дерева.
     */
    public int getNodeCount() {
        return nodeCount;
    }

    /**
     * Метод вызывает метод добавления узла в дерево.
     * @param value значение добавляемого узла.
     */
    public void add(int value) {
        root = addNode(root, value);
        nodeCount++;
    }

    private Node addNode(Node root, int value) {
        /* Если дерево пустое - создаём корень */
        if (root == null) {
            root = new Node(value);
            return root;
        }

        /* Иначе двигаемся по дереву рекурсивно, создавая узлы */
        if (value < root.value) {
            root.left = addNode(root.left, value);
        } else {
            root.right = addNode(root.right, value);
        }
        return root;
    }

    /**
     * Метод вызывает метод, проверяющий наличие в дереве узла с указанным значением.
     * @param value проверяемое значение.
     * @return true - если значение узла найдено в дереве, иначе false.
     */
    public boolean contains(int value) {
        return containsNode(root, value);
    }

    private boolean containsNode(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        return value < root.value
                ? containsNode(root.left, value)
                : containsNode(root.right, value);
    }

    /**
     * Метод вызывает метод, удаляющий узел с указанным значением.
     * @param value значение удаляемого узла.
     */
    public void remove(int value) {
        root = removeNode(root, value);
        nodeCount--;
    }

    private Node removeNode(Node root, int value) {
        /* Дерево пустое */
        if (root == null) return null;

        /* Иначе двигаемся по дереву рекурсивно */
        if (value < root.value) {
            root.left = removeNode(root.left, value);
        } else if (value > root.value) {
            root.right = removeNode(root.right, value);
        } else {
            /* Узел с одним потомком или без них */
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            /* Узел с двумя потомками - получаем наименьший узел в правом поддереве */
            root.value = minValue(root.right);
            /* Удаляем найденный узел */
            root.right = removeNode(root.right, root.value);
        }
        return root;
    }

    private int minValue(Node root) {
        int minVal = root.value;
        while (root.left != null) {
            minVal = root.left.value;
            root = root.left;
        }
        return minVal;
    }

    /**
     * Метод вызывает метод префиксного обхода дерева.
     */
    public void printPreOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root != null) {
            printValue(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * Метод вызывает метод инфиксного обхода дерева.
     */
    public void printInOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            printValue(root.value);
            inOrder(root.right);
        }
    }

    /**
     * Метод вызывает метод постфиксного обхода дерева.
     */
    public void printPostOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            printValue(root.value);
        }
    }

    private void printValue(int value) {
        log.info("{} ", value);
    }

    /**
     * Метод очищает дерево.
     */
    public void clearTree() {
        root = null;
        nodeCount = 0;
    }
}
