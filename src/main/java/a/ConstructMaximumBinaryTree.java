package a;

import F.TreeNode;

public class ConstructMaximumBinaryTree {
    TreeNode root=null;
    public static void main(String[] args) {
        int [] nums = {3,2,1,6,0,5};
        TreeNode treeNode = new ConstructMaximumBinaryTree().constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null) return root;
        return constructMaximumBinaryTreeRes(nums,0,nums.length-1);

    }
    public TreeNode constructMaximumBinaryTreeRes(int[] nums,int start,int end) {
        if(end<start) return null;
        int idxMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idxMax]) {
                idxMax = i;
            }
        }
        TreeNode curr = new TreeNode(nums[idxMax]);
        curr.left = constructMaximumBinaryTreeRes(nums, start, idxMax - 1);
        curr.right = constructMaximumBinaryTreeRes(nums, idxMax + 1, end);
        return curr;

    }
    public int findMax(int [] array,int start,int end){
        int idxMax = start;

        for (int i = start+1; i < end; i++) {
            if (array[i] > array[idxMax]) {
                idxMax=i;
            }
        }
        return idxMax;
    }

}
