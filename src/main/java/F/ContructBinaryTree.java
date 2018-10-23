package F;

import miss.Tree;

public class ContructBinaryTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root =new ContructBinaryTree().buildTree(preorder, inorder);

    }

    public void preOrder(TreeNode buildTree) {
        System.out.println(buildTree.val);
        preOrder(buildTree.left);
        preOrder(buildTree.right);
    }

    public void postOrder(TreeNode buildTree) {

        preOrder(buildTree.left);
        System.out.println(buildTree.val);
        preOrder(buildTree.right);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
