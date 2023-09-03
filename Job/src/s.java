import java.util.ArrayList;
import java.util.List;

class TreeNode1 {
    String name;
    int value;
    List<TreeNode1> children;

    public TreeNode1(String name) {
        this.name = name;
        this.value = 0;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode1 child) {
        children.add(child);
    }
}