package a;
import java.util.*;

public class ZigzagLevelOrder {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res= new ArrayList();
        if(root==null) return res;
        LinkedList<TreeNode> ls= new LinkedList();
        LinkedList ls1= new LinkedList();
        boolean fromLeft = false;
        ls.add(root);

        while(!ls.isEmpty()){
            ArrayList<Integer> ar = new ArrayList<Integer>();
            while(!ls.isEmpty()){

                TreeNode val =ls.poll();
                ar.add(val.val);
                if(fromLeft){
                    ls1.add(val.left);
                    ls1.add(val.right);
                } else{
                    ls1.add(val.right);
                    ls1.add(val.left);
                }
            }
            res.add(ar);
            ls=ls1;
            fromLeft=!fromLeft;
        }

        return res;
    }
}
