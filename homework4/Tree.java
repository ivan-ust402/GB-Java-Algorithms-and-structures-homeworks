package homeworks.homework4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
    // Нужно реализовать структуру, которая умеет делать следующее:
    // 1. Вставка значения
    // 2. Поиск значения (проверка, есть ли значение или нет)
    // 3, Удаление значения 
    // DFS Depth-first-search - поиск в глубину
    // BFS Breath-first-search - поиск в ширину 

    private class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> root;

    public boolean add(T value) {
        if (root == null) {
            root = new Node<T>(value);
            return true;
        }

        return addNode(root, value);

        
    }

    private boolean addNode(Node<T> current, T value) {
        if (value.compareTo(current.value) == 0){
            return false;
        } else if (value.compareTo(current.value) < 0) {
            if (current.left == null) {
                 // Вставляем в левое поддерево
                 current.left = new Node<T>(value);
                 return true;
            } else {
                return addNode(current.left, value);
            }
            
        } else { // value > root.value или value.compareTo(current.value) > 0
            if (current.right == null) {
                // Вставляем в правое поддерево
                current.right = new Node<T>(value);
                return true;
           } else {
               return addNode(current.right, value);
           }

        }
    }

    public boolean contains(T value) {
        // Попытаться найти узел, значение которого равно value
        // Если узла нет, то false
        return findNode(root, value) != null;
    }

    private Node<T> findNode(Node<T> current, T value) {
        if (current == null) {
            return null;
        }
        //  Найти узел в дереве current значение которого равно value
        if (value.compareTo(current.value) == 0) {
            return current; 
        } else if (value.compareTo(current.value) < 0) {
            return findNode(current.left, value);
        } else { // current.value < value
            return findNode(current.right, value); 
        }

    }

    public void remove(T value) {
        root = removeNode(root, value);
    }

    private Node<T> removeNode(Node<T> current, T value) {
        if(current == null) {
            return null;
        }

        if(value.compareTo(current.value) < 0) {
            // Нужно удалить в левом поддереве
            current.left = removeNode(current.left, value);
            return current;
        } else if(value.compareTo(current.value) > 0) {
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
        Node<T> smallestNodeOnTheRight  = findFirst(current.right);
        T smallestValueOnTheRight  = smallestNodeOnTheRight.value;
        current.value = smallestValueOnTheRight; 
        current.right = removeNode(current.right, smallestValueOnTheRight);
        return current;
    }

    public T findFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return findFirst(root).value;
    }
    // Поиск минимального элемента в каком-то дереве
    private Node<T> findFirst(Node<T> current){
        if (current.left == null) {
            return current;
        }
        return findFirst(current.left);
    }

    public List<T> dfs() {
        if(root == null) {
            return List.of(); 
        }
        List<T> list = new ArrayList<>();
        dfs(root, list);
        return list; 
    }

    private void dfs(Node<T> current, List<T> result) {
        // In -order
        if(current.left != null) {
             dfs(current.left, result);
        }
        result.add(current.value); 
        if(current.right != null) {
            dfs(current.right, result);
       }
    }

    public List<T> bfs() {
        if(root == null) {
            return List.of();
        }
        List<T> result = new ArrayList<>();
        Queue<Node<T>> nodes = new LinkedList<>();

        nodes.add(root);

        while(!nodes.isEmpty()) {
            Node<T> next = nodes.poll(); 
            result.add(next.value);
            if(next.left != null) {
                 nodes.add(next.left);  
            }
            if(next.right != null) {
                nodes.add(next.right );  
            }
        }
        return result; 
    }
}
