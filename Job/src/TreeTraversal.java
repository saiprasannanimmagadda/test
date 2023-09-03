import java.util.ArrayList;
import java.util.List;



public class TreeTraversal {
    public static void listParentsAndChildren(TreeNod root) {
        listParentsAndChildrenHelper(root);
    }
    static ArrayList<Integer> b = new ArrayList<>();

    private static void listParentsAndChildrenHelper(TreeNod node) {
        if (node == null) {
            return;
        }

        System.out.print("Parent: " + node.val + " - Children: ");
        for (TreeNod child : node.children) {
            System.out.print(child.val + " ");
            b.add(child.val);
            
        }
        System.out.println();

        for (TreeNod child : node.children) {
            listParentsAndChildrenHelper(child);
        }
        
    }

    public static void main(String[] args) {
        // Create a sample tree
        TreeNod root = new TreeNod(1);
        TreeNod child1 = new TreeNod(2);
        TreeNod child2 = new TreeNod(3);
        TreeNod child3 = new TreeNod(4);
        TreeNod child4 = new TreeNod(5);
        TreeNod child5 = new TreeNod(6);
        TreeNod child6 = new TreeNod(7);
        TreeNod child7 = new TreeNod(8);
        TreeNod child8 = new TreeNod(9);
        TreeNod child9 = new TreeNod(10);
        TreeNod child10 = new TreeNod(11);
        TreeNod child11 = new TreeNod(12);
        TreeNod child12 = new TreeNod(13);
        TreeNod child13 = new TreeNod(14);
        TreeNod child14 = new TreeNod(15);
        
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        root.children.add(child4);
        
        child1.children.add(child5);
        child1.children.add(child6);
        child1.children.add(child7);
        
        child2.children.add(child8);
        child2.children.add(child9);
        child2.children.add(child10);
        
        child3.children.add(child11);
        child3.children.add(child12);
        child3.children.add(child13);
        
       // child4.children.add(child14);
        

        listParentsAndChildren(child2);
        System.out.println(b);
    }
}
