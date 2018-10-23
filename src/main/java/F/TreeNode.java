package F;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public static TreeNode makeTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }
    public static TreeNode makeTree1(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        return root;
    }


    public static TreeNode makeTree3(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(5);
        return root;
    }

    public static TreeNode makeTree4(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left= new TreeNode(5);
        root.left.right= new TreeNode(1);
        return root;
    }


    public static TreeNode makeTree6(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left= new TreeNode(2);
        root.left.right= new TreeNode(4);
        //root.right.left= new TreeNode(2);
        root.right.right= new TreeNode(7);
        return root;
    }

    public static TreeNode makeTree5(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);

        return root;
    }


    public static TreeNode makeTree7(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left= new TreeNode(1);
        root.left.right= new TreeNode(2);
        //root.right.left= new TreeNode(2);
        root.right.right= new TreeNode(7);
        return root;
    }

    public static TreeNode makeTree8(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        return root;
    }


    public static TreeNode makeTree9(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left= new TreeNode(1);
        root.left.right= new TreeNode(2);
        root.left.right.right= new TreeNode(0);
        //root.right.left= new TreeNode(2);
        root.right.right= new TreeNode(7);
        return root;
    }


    public static TreeNode makeTree10(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left= new TreeNode(15);
        root.left.right= new TreeNode(17);
        return root;
    }

    public static TreeNode makeTree12(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }


}
