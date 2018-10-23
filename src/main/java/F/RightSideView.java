package F;
import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return null;
        List<Integer> ls = new ArrayList<Integer>();
        TreeNode p = root;
        while (root != null) {
            ls.add(root.val);
            p = root;
            root = root.right;
        }
        if (p.left != null) {
            ls.add(p.left.val);
        }
        return ls;
    }
}
