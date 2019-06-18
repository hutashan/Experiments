
/**
 * Using recursion to create in place mirror tree.
 * Method name is createInpaceMirror
 * Steps:-
         Break condition for recursion if node ==null.
         1)  Call createInpaceMirror for left-subtree  createInpaceMirror(tree.left)
         2)  Call createInpaceMirror for right-subtree Mirror(tree.right)
        (3)  Swap left and right subtrees.
 */

public class TreeMirror {
    private TreeNode root = null;


    /**
     * make inplace mirror of any give tree
     * @param node
     * @return node
     */

    public TreeNode createInpaceMirror(TreeNode node){
        if(node==null)
            return null;
        // recursion call to create left subtrees
        TreeNode left = createInpaceMirror(node.left);
        // recursion call to create right subtrees
        TreeNode right = createInpaceMirror(node.right);
        // swap pointers
        node.left=right;
        node.right=left;
        return node;
    }

    public static void main(String[] args) {

        // create tree and printing inorder.
        TreeMirror treeMirror  = new TreeMirror();
        treeMirror.root = treeMirror.buildTree();
        System.out.println("Testing given example and using inorder traversal to verify tree");
        System.out.println("Inorder traversal for original tree"  );
        treeMirror.inOrder(treeMirror.root);

        // After mirror original tree. Printing inorder.
        System.out.println("");
        System.out.println("Inorder traversal for mirror tree"  );
        treeMirror.root = treeMirror.createInpaceMirror(treeMirror.root);
        treeMirror.inOrder(treeMirror.root);

        // Mirror of mirrored tree should be equal to original given tree. Printing Inorder mirror of mirrored tree.
        System.out.println("");
        System.out.println("Mirror of mirrored tree should be equal to original tree.(Testing purpose) ");
        System.out.println("Inorder traversal for mirror of mirror tree" );
        treeMirror.root = treeMirror.createInpaceMirror(treeMirror.root);
        treeMirror.inOrder(treeMirror.root);

    }


    void inOrder(TreeNode node)
    {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }



    // tree build
    public TreeNode buildTree(){
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('E');
        root.left.left= new TreeNode('C');
        root.left.right= new TreeNode('D');
        root.right.right = new TreeNode('F');
        return root;
    }



   // Tree structure
    public class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x) { val = x; }

    }
}

