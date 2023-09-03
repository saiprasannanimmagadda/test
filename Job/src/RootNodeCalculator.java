import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    List<TreeNode> children;

    public TreeNode() {
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}

public class RootNodeCalculator {
    public static void main(String[] args) {
        // Create the tree structure
        TreeNode root = new TreeNode();
        TreeNode child1 = new TreeNode();
        TreeNode child2 = new TreeNode();
        TreeNode child3 = new TreeNode();

        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);

        TreeNode child11 = new TreeNode();
        TreeNode child12 = new TreeNode();
        TreeNode child13 = new TreeNode();
        TreeNode child21 = new TreeNode();
        TreeNode child22 = new TreeNode();

        child1.addChild(child11);
        child1.addChild(child12);
        child1.addChild(child13);
        child2.addChild(child21);
        child2.addChild(child22);

        // Assign values to the leaf nodes
        child11.value = 3;
        child12.value = 4;
        child13.value = 6;
        child21.value = 9;
        child22.value = 8;

        // Calculate the root node value
        int rootNodeValue = calculateRootValue(root);
        System.out.println("Root node value: " + rootNodeValue);
    }

    public static int calculateRootValue(TreeNode node) {
        if (node.isLeaf()) {
            return node.value;
        }

        int sum = 0;
        for (TreeNode child : node.children) {
            sum += calculateRootValue(child);
        }
        node.value = sum; // Assign the calculated value to internal nodes
        System.out.println("Root node value: " + node.value);
        return sum;
    }
}
