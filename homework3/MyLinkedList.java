package homeworks.homework3;

public class MyLinkedList {

    private Node head;
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(int value) {
        // Добавляем в конец нашего списка значение
        if (head == null) {
            head = new Node(value);
        } else {
            Node last = findLast();
            last.next = new Node(value);
        }
    }

    private Node findLast() {
        if (head == null) {
            return null; 
        }

        Node cursor = head;

        while (cursor.next == null) {
            cursor = cursor.next;
        }

        return cursor;
    }
}
