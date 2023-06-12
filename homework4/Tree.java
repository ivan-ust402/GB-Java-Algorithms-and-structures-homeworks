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

    public boolean contains(int value) {
        // Попытаться найти узел, значение которого равно value
        // Если узла нет, то false
        return findNode(root, value) != null;
    }

    private Node findNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        //  Найти узел в дереве current значение которого равно value
        if (current.value == value) {
            return current; 
        } else if (current.value > value) {
            return findNode(current.left, value);
        } else { // current.value < value
            return findNode(current.right, value); 
        }

    }

    public void remove(int value) {
        root = removeNode(root, value);
    }

    private Node removeNode(Node current, int value) {
        if(current == null) {
            return null;
        }

        if(value < current.value) {
            // Нужно удалить в левом поддереве
            current.left = removeNode(current.left, value);
            return current;
        } else if(value < current.value) {
            // Удалить в правом поддереве
            current.right = removeNode(current.right, value);
            return current;
        }

        // Нужно удалить узел 
        // Есть три случая:
        // 1. Дочерних узлов нет 
        if (current.left == null && current.right == null) {
            return null;
        }
        // 2. Есть дочерний узел, либо левый, либо правый
        if (current.left == null && current.right != null) {
            return current.right;
        }

        if (current.right == null && current.left != null) {
            return current.left;
        }
        // 3. Есть оба дочерних узла
        // Нужно найти минимальный элемент справа или максимальный слева
        // Нужно
        Node smallestNodeOnTheRight  = findFirst(current.right);
        int smallestValueOnTheRight  = smallestNodeOnTheRight.value;
        current.value = smallestValueOnTheRight; 
        current.right = removeNode(current.right, smallestValueOnTheRight);
        return current;
    }

    // Поиск минимального элемента в каком-то дереве
    private Node findFirst(Node current){
        if (current.left == null) {
            return current;
        }
        return findFirst(current.left);
    }
}
