package homeworks.homework4;

public class Lesson4 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println(tree.add(8));
        System.out.println(tree.add(1));
        System.out.println(tree.add(3));
        System.out.println(tree.add(12));
        System.out.println(tree.add(12));
        //          8
        //      1       12
        //          3
    }
}