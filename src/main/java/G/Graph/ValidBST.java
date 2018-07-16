package G.Graph;

public class ValidBST {
    TreeNode root;
    public static void main(String arg[]){
        InorderSuccessorBST obj = new InorderSuccessorBST();
        ValidBST o = new ValidBST();
        o.root =obj.range();
        System.out.println(o.isValidBST(o.root));


    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null && !IsValid(root.left,null,root.val)) return false;
        if( root.right!=null && !IsValid(root.right,root.val,null)) return false;
        return true;
    }

    public boolean IsValid(TreeNode root,Integer minVal,Integer maxVal){
        if(root==null) return true;
        if(minVal!=null && root.val<=minVal) return false;
        if(maxVal !=null && root.val>=maxVal) return false;
        if(!IsValid(root.left,minVal,root.val)) return false;
        if(!IsValid(root.right,root.val,maxVal)) return false;
        return true;
    }

}
