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

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }

        return addNode(root, value);

        
    }

    private boolean addNode(Node current, int value) {
        if (value == current.value){
            return false;
        } else if (value < current.value) {
            if (current.left == null) {
                 // Вставляем в левое поддерево
                 current.left = new Node(value);
                 return true;
            } else {
                return addNode(current.left, value);
            }
            
        } else { // value > root.value
            if (current.right == null) {
                // Вставляем в правое поддерево
                current.right = new Node(value);
                return true;
           } else {
               return addNode(current.right, value);
           }

        }
    }
}
