package G.Graph;

public class InorderSuccessorBST {
    TreeNode root;
    int signal = 0;

    public static void main(String arg[]) {
        InorderSuccessorBST obj = new InorderSuccessorBST();
        obj.root =obj.makeTree();


        System.out.println(new InorderSuccessorBST().inorderSuccessor(obj.root, new TreeNode(1)).val);
    }

    public TreeNode makeTree() {
        this.root = new TreeNode(2);

    TreeNode left = new TreeNode(1);
        root.left =left;
        TreeNode right = new TreeNode(3);
        root.right =right;
        return root;
    }
    public TreeNode inValid() {
        this.root = new TreeNode(10);

        TreeNode left = new TreeNode(5);
        root.left =left;
        TreeNode right = new TreeNode(15);
        root.right =right;
        right.right=new TreeNode(20);
        right.left=new TreeNode(6);
        return root;
    }


    public TreeNode range() {
        this.root = new TreeNode(-2147483648);
        TreeNode right = new TreeNode(2147483647);
        root.right =right;

        return root;
    }




    public TreeNode makeTreeComplex() {
        this.root = new TreeNode(10);

        TreeNode left = new TreeNode(6);
        root.left =left;
        left.left=new TreeNode(2);
        left.right=new TreeNode(9);
        TreeNode right = new TreeNode(12);

        root.right =right;

        return root;
    }
    public TreeNode make2() {
        this.root = new TreeNode(8);

        TreeNode left = new TreeNode(2);
        root.left =left;
       // left.left=new TreeNode(2);
      //  left.right=new TreeNode(9);
      //  TreeNode right = new TreeNode(12);

       // root.right =right;

        return root;
    }

    TreeNode ceiling = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return ceiling;
        }
        if (root.val <= p.val) {
            inorderSuccessor(root.right, p);
        } else {
            ceiling = root;
            inorderSuccessor(root.left, p);
        }
        return ceiling;
    }





    private boolean flag;
    private TreeNode target;
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        find(root, p);
        return target;
    }

    private void find(TreeNode root, TreeNode p) {
        if (root == null)
            return;
        find(root.left, p);
        if (this.flag) {
            target = root;
            flag = false;
        }
        if (p.val == root.val) {
            this.flag = true;
        }

        find(root.right, p);
    }





    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode suc = null;
        if (p.right != null) {

            return findMin(p);
        } else {
            TreeNode current = root;

            while (current != null) {
                if (current.val < p.val) {
                    suc = current;
                    current = current.left;
                } else {
                    //    suc = current;
                    current = current.right;
                }
            }

        }
        return suc;
    }



    TreeNode findMin(TreeNode current){

        while(current.left!=null){
            current = current.left;
        }
        return current;
    }


}
