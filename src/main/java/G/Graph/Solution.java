package G.Graph;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(null));
    }
    TreeNode root;
    public TreeNode makeTree() {
        this.root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        root.left =left;
        TreeNode right = new TreeNode(3);
        root.right =right;
        TreeNode right1 = new TreeNode(3);
        right.right =right1;
        TreeNode right11 = new TreeNode(5);
        right1.right =right11;
        TreeNode right12 = new TreeNode(4);
        right11.right =right12;
        TreeNode left2 = new TreeNode(6);
        right.left =left2;
        return root;
    }


        public int solution(TreeNode T) {

            makeTree();

            // write your code in Java SE 8
            if(root==null) return 0;
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            return recursionUnquePath(root,map);
        }
        public int recursionUnquePath(TreeNode root,HashMap<Integer,Integer> map){
            if(root==null){
                return map.size();
            }
            ;
            if(map.containsKey(root.val)){

            }



            int max = Math.max(recursionUnquePath(root.left,map),recursionUnquePath(root.right,map));
            int v2 = map.get(root.val);

            map.put(root.val,v2-1);
            if(map.get(root.val)==0){
                map.remove(root.val);
            }
            return max;

        }


}
