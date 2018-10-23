package M;
import java.util.*;
import F.TreeNode;

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        List<List> l = new ZigzagLevelOrder().zigzagLevelOrder(TreeNode.makeTree());

    }
    public List<List> zigzagLevelOrder(TreeNode root) {
        List<List> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if(order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }
}
