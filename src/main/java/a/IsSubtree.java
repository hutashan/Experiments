package a;

import F.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubtree {
    TreeNode sub =null;
    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree7();
        TreeNode subTree = TreeNode.makeTree9();
        System.out.println(new IsSubtree().isSubtree(root,subTree));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();


    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        findNode(s,t.val);
        if(sub==null) return false;
        return isSubTreeRes(t,sub);

    }
    private boolean isSubTreeRes (TreeNode root, TreeNode subTree){
        if(root==null && subTree ==null) return true;
        if(root==null) return false;
        if(subTree==null) return false;
        if(root.val!=subTree.val) return false;
        return (isSubTreeRes(root.left,subTree.left) && isSubTreeRes(root.right,subTree.right));
    }

    private void findNode (TreeNode root, int val){

        if(root==null || sub!=null) return ;

        if(root.val==val) {
            sub= root;
            return;
        }
        findNode(root.left,val);
        findNode(root.right,val);

    }


}
