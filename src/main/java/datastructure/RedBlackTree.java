package datastructure;

/**
 * Created by parmana on 3/6/17.
 */
public class RedBlackTree {
      public Node root;

    private class Node{
        int value;
        boolean color;
        Node left,right;

      public Node(int val,boolean col){
          this.value=val;
          this.color=col;
      }

    }


    public void put(int value,boolean color){
        if(root==null){
         root=new Node(value,false);
        } else {
            root=  put(root,value,color);
        }



    }

    public Node put(Node h,int value,boolean color){
        if(h==null){
            return new Node(value,color);
        }

        if(value>h.value) h.right= put(h.right,value,color);
         else if(value<h.value) h.left= put(h.left,value,color);
        else
            h.value=value;
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
       return h;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == true;
    }
    private Node rotateRight(Node h) {
        // assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = true;
        //x.size = h.size;
        //h.size = size(h.left) + size(h.right) + 1;
        return x;
    }


    public void printInOrderRec(Node h){
        if(h==null){
            return;
        }
        printInOrderRec(h.left);
        System.out.println(h.value);
        printInOrderRec(h.right);
    }



    public static void main(String[] args) {
        RedBlackTree obj = new RedBlackTree();
        obj.start();
    }


    public void start(){
        RedBlackTree obj = new RedBlackTree();
        obj.put(10,false);
        obj.put(4,true);
        obj.put(3,true);
        //obj.put(15,false);
        //obj.put(16,false);
        obj.printInOrderRec(obj.root);
    }

}
