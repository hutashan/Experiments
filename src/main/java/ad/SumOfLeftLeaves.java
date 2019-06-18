package ad;

import F.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(TreeNode.makeTree3()));

    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }
}
