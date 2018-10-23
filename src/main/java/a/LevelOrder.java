package a;

import F.TreeNode;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree10();
        List<List<Integer>> res = new LevelOrder().levelOrder(root);
        for(List<Integer> ls : res){
            for (int a : ls){
                System.out.print(a +" ,");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                ls.add(cur.val);
            }
            res.add(ls);
        }
        return res;
    }







    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
      //  Queue<TreeNode> qu = new LinkedList<TreeNode>();

        Stack<TreeNode> st = new Stack<TreeNode>();

        Stack<TreeNode> quTemp = new Stack<TreeNode>();
        quTemp.push(root);
        while (!quTemp.isEmpty()) {
            Stack<TreeNode> qu = quTemp;
            quTemp = new Stack<TreeNode>();
            List<Integer> ls = new ArrayList<>();
            while (!qu.isEmpty()) {

                TreeNode tr = qu.pop();
                ls.add(tr.val);
                if (tr.right != null)
                    quTemp.push(tr.right);
                if (tr.left != null)
                    quTemp.push(tr.left);

            }
            res.add(ls);
        }
        return res;
    }


}
