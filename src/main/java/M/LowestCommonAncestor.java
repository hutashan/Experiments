package M;
import F.TreeNode;
import java.util.*;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.makeTree3();
        TreeNode v = new LowestCommonAncestor().lowestCommonAncestor(treeNode,4,5);
        System.out.println(v.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root==null || p==root.val || q==root.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right !=null) return root;
        if(left!=null) return left;
        else return right;


    }
}
