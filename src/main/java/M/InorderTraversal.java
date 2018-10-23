package M;
import F.TreeNode;
import java.util.*;

public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root =  TreeNode.makeTree12();
        List<Integer> ls =new InorderTraversal().inorderTraversal(root);
        for(int ls1 :ls ){
            System.out.println(ls1);
        }

    }
    public List<Integer> inorderTraversalTest(TreeNode root) {

        return inorderTraversal(root);
       // return ls;
    }

    public List<Integer> inorderTraversalRes(TreeNode root,List<Integer> ls) {
        if(root.left!=null)   inorderTraversalRes(root.left,ls);
        ls.add(root.val);
        if(root.right!=null)   inorderTraversalRes(root.right,ls);
        return ls;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ls1 = new ArrayList<>();
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ls1.add(curr.val);
            curr =curr.right;
        }
        return ls1;
    }
}
