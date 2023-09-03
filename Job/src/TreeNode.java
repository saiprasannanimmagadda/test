import java.util.ArrayList;
import java.util.List;

class TreeNod {
    int val;
    List<TreeNod> children;

    public TreeNod(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}