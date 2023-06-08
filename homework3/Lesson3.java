package homeworks.homework3;


public class Lesson3 {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3); 
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.pop(2));
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.popFirst());
        System.out.println(myLinkedList);
    } 
}
