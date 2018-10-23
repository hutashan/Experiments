package a;

import F.TreeNode;

public class SumNumbers {
    int TotalSumn =0;
    public static void main(String[] args) {
    TreeNode root = TreeNode.makeTree5();
        System.out.println(new SumNumbers().sumNumbers(root));
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        sumNumbersRes(root,0);
        return TotalSumn;
    }

    public void sumNumbersRes(TreeNode root,int num) {
        if(root==null) return;
        if(root.right==null && root.left==null) {
            num = num+root.val;
            TotalSumn = TotalSumn +num;
            return;
        }
        sumNumbersRes(root.left,(num+root.val)*10);
        sumNumbersRes(root.right,(num+root.val)*10);



    }
}
