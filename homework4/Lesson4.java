package homeworks.homework4;

public class Lesson4 {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        System.out.println(tree.add(8));
        System.out.println(tree.add(1));
        System.out.println(tree.add(3));
        System.out.println(tree.add(12));
        System.out.println(tree.add(12));
        //              8
        //      1               12
        //          3 
        System.out.println();
        System.out.println(tree.contains(8));
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(12)); 
 
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(14));

        System.out.println(tree.findFirst());
        System.out.println();
        // tree.remove(8);
        // tree.remove(12);
        // tree.remove(12);
        System.out.println(tree.contains(8));
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(12));
        System.out.println(tree.dfs());
        System.out.println(tree.bfs());
        
    }
}
