package F;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        String res = "";
        List<String> ls = new ArrayList<String>();
        binaryTreePathUtil(root, res, ls);
        return ls;

    }

    public void binaryTreePathUtil(TreeNode root, String res, List<String> ls) {
        if ((root.left == null) && (root.right == null)) {
            ls.add(res + root.val);
            if (root.left != null) binaryTreePathUtil(root.left, res + root.val + "->", ls);
            if (root.right != null) binaryTreePathUtil(root.right, res + root.val + "->", ls);
        }
    }
}
