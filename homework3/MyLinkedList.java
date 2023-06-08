package homeworks.homework3;

public class MyLinkedList<T> {

    private Node<T> head;

    // Домашнее задание:
    // Реализовать в классе MyLinkedList следующие методы:
    // 1. public int size() - получение размера списка, проитерироваться по структуре 
    // 1.1* Можно завети переменную и поддерживать ее
    // 2. public boolean contains(T value) Проверка наличия элемента по значению 
    // 3. public T popLast() удалить последний. Если спиок пустой - ошибка.
    // 4. * Переделать все значения int на T, чтобы можно было хранить значения всех типов
    // 5. * public MyLinkedList reverse() - создать Новый список порядок, в котором  обратный текущему 

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(T value) {
        // Добавляем в конец нашего списка значение
        Node<T> lastNode = findLast();

        if(lastNode == null) {
            head = new Node<T>(value);
        } else {
            lastNode.next = new Node<T>(value);
        }
    }

    public int size() {
        if (head == null) {
            return 0; 
        } 

        Node<T> cursor = head;
        int length = 1;

        while (cursor.next != null ) {
                length++;
                cursor = cursor.next;
            }
        return length;     
    }

    public boolean contains(T value){
        if (head == null) {
            throw new IllegalStateException("Список пустой!"); 
        } 

        Node<T> cursor = head;

        while (cursor != null) {
            if (cursor.value == value) {
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }



    public T getFirst() {
        return get(0); 
    }


    public T get(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пустой!"); 
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index ) ; 
        }

        Node<T> cursor = head;
        int indexCursor = 0;

        while (cursor != null) {
            if (indexCursor == index) {
                return cursor.value;
            }
            cursor = cursor.next;
            indexCursor++;
        }
        throw new IndexOutOfBoundsException();
    }

    public T popFirst() {
        return pop(0);
    }

    public T popLast() {
        int last = size() - 1;
        return pop(last);
    }

    public T pop(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пустой!"); 
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index); 
        }

        if (index == 0) {
            T pop = head.value;
            head = head.next; 
            return pop;
        }

        Node<T> cursor = head;
        int indexCursor = 1;

        while (cursor.next != null ) {
            if (indexCursor == index) {
                if(head.next == null) {
                    throw new IndexOutOfBoundsException(index) ; 
                }
                T pop = cursor.next.value;
                cursor.next = cursor.next.next;
                return pop;
            }
            cursor = cursor.next;
            indexCursor++;
        }
        throw new IndexOutOfBoundsException(); 
    }

    private Node<T> findLast() {
        if (head == null) {
            return null; 
        }

        Node<T> cursor = head;

        while (cursor.next != null) {
            cursor = cursor.next;
        }

        return cursor;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> cursor = head;
        while (cursor != null) {
            result.append(cursor.value).append(" ->  ");
            cursor = cursor.next;
        }  

        int length = result.length();
        if(length > 4) {
            result.delete(length - 4, length);
        }
        result.append("]");
        return result.toString();
    }
}
