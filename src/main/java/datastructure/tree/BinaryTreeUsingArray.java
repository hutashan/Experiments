package datastructure.tree;


import sun.jvm.hotspot.opto.Node_Array;

public class BinaryTreeUsingArray {

    public static void main(String arg[]) {
        int[] arr = {-1, 0, 0, 1, 2, 2, 4, 4};
        Node [] nodeArray = new Node[arr.length];
        for (int i=0;i<arr.length;i++){
            nodeArray[i]=new Node(i,i+"");
        }

        Node root =null;
        for (int i=0;i<arr.length;i++){
           if (arr[i]==-1){
               root =nodeArray[i];
           } else {
               Node parent = nodeArray[arr[i]];
               if (parent.left==null){
                   parent.left=nodeArray[i];
               } else {
                   parent.right=nodeArray[i];
               }



           }



        }

        inOrder(root);


    }

   static public void inOrder(Node root){
        if (root==null) return;
        System.out.println(root.key);
        inOrder(root.left);
        inOrder(root.right);
    }


}
