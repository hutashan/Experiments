package a;

import F.TreeNode;

import java.util.HashSet;

public class FindTarget {
    public static void main(String[] args) {
    TreeNode root = TreeNode.makeTree6();
        System.out.println(new FindTarget().findTarget(root,9));
    }
    public boolean findTarget(TreeNode root, int k) {

        if(root==null) return false;
        return findTargetRes(root,k,new HashSet<Integer>());

    }
    public boolean findTargetRes(TreeNode root, int k,HashSet<Integer> set) {
        if(root==null) return false;
        if (set.contains(k-root.val)) {
            return true;
        } else{
            set.add(root.val);
        }
        return findTargetRes(root.left,k,set) || findTargetRes(root.right,k,set);




    }
}
