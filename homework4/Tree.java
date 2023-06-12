package homeworks.homework4;

public class Tree {
    // Нужно реализовать структуру, которая умеет делать следующее:
    // 1. Вставка значения
    // 2. Поиск значения (проверка, есть ли значение или нет)
    // 3, Удаление значения 

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
    }
}
