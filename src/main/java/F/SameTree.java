package F;

public class SameTree {
    public static void main(String[] args) {
    TreeNode root = TreeNode.makeTree();
        TreeNode root1 = TreeNode.makeTree1();
        System.out.println(new SameTree().isSameTree(root,root1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if((p==null && q!=null) || (p!=null && q==null)) return false;
        if(p.val!=q.val){
            return false;
        }
        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));

    }
}
