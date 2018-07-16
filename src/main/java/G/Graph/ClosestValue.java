package G.Graph;

public class ClosestValue {
    TreeNode root;
    public static void main (String arg[]){
       // System.out.println(Math.round());
        InorderSuccessorBST obj = new InorderSuccessorBST();
        ClosestValue o = new ClosestValue();
        o.root =obj.make2();
        System.out.println(o.closestValue(o.root,6.0));

    }
    public int closestValue(TreeNode root, double target) {
        int l = root.val;
        int r = root.val;
        TreeNode curr= root;
        while(curr!=null){
            if(curr.val<target){
                l = curr.val;
                curr = curr.right;
            } else {
                r =curr.val;
                curr = curr.left;
            }
        }
        return Math.abs(target - l) < Math.abs(r - target) ? l : r ;
    }


    public int closestValueGood(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
                if (Math.abs(target - root.val) <= 0.5)
                    break;
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }


    public int closestValueNotworkging(TreeNode root, double target) {
        if (root ==null) return 0;

        int round = java.lang.Math.round(java.lang.Math.round(target));
        while (true){


            if(root.val==round) return root.val;
            if((root.left==null && root.right==null || (Math.abs(root.val-round)<Math.abs(root.left.val-round)))){
                return root.val;
            }
            if(round>root.val && root.right==null){
                return root.val;
            }
            if((round<root.val && root.left==null) || Math.abs(root.val-round)<Math.abs(root.right.val-round)){
                return root.val;
            }

            if(Math.abs(root.val-round)<Math.abs(root.right.val-round)&& (Math.abs(root.val-round)<Math.abs(root.left.val-round))){
                return root.val;
            }
            if(root.val<round){
                root=root.right;
            } else{
                root=root.left;
            }


        }

    }

}
