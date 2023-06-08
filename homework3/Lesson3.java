package homeworks.homework3;


public class Lesson3 {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3); 
        System.out.println("Лист: " + myLinkedList);
        System.out.println("Get first: " + myLinkedList.getFirst());
        System.out.println("Get of 0: " + myLinkedList.get(0));
        System.out.println("Get of 1: " + myLinkedList.get(1));
        System.out.println("Get of 2: " + myLinkedList.get(2));
        System.out.println("size: " + myLinkedList.size());
        System.out.println("Удаление по индексу: " + myLinkedList.pop(2));
        System.out.println("size: " + myLinkedList.size());
        System.out.println("Лист: " + myLinkedList);
        System.out.println("Удалить первый: " + myLinkedList.popFirst());
        System.out.println("size: " + myLinkedList.size());
        System.out.println("Лист:" + myLinkedList);
        System.out.println("size: " + myLinkedList.size());
        System.out.println("Contains 2: " + myLinkedList.contains(2));
        System.out.println("Contains 1: " + myLinkedList.contains(1));
        System.out.println("Contains 3: " + myLinkedList.contains(3));
    } 
}
