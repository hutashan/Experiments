package F;

public class DiameterOfBinaryTree {
    int max =0;
    public static void main(String[] args) {
    TreeNode root = TreeNode.makeTree3();
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
         diameterOfBinaryTreeRecus(root);
         return max;
    }
    public int diameterOfBinaryTreeRecus(TreeNode root) {
        if(root==null) return 0;
        int left = diameterOfBinaryTreeRecus(root.left);
        int right =diameterOfBinaryTreeRecus(root.right);
        max = Math.max(max,left+right);
        return Math.max(left,right)+1;


    }
}
