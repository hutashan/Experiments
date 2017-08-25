package datastructure.tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    static class Node {
        int key;
        String data;
      public  Node left, right;

        public Node(int key, String data) {
            this.data = data;
            this.key = key;
        }
    }



    public Node root;

    Node getRoot() {
        return root;
    }

    Boolean isEmpty() {
        return (root == null);
    }

    public void addNode(int key, String data) {
        Node newNode = new Node(key, data);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }


    }

    public void inOrder(Node focusNode) {
        if (focusNode != null) {
            inOrder(focusNode.left);
            System.out.println(focusNode.key + focusNode.data);
            inOrder(focusNode.right);
        }
    }

    public void preOrder(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode.key + focusNode.data);
            preOrder(focusNode.left);
            preOrder(focusNode.right);
        }
    }

    public void postOrder(Node focusNode) {
        if (focusNode != null) {
            postOrder(focusNode.left);
            postOrder(focusNode.right);
            System.out.println(focusNode.key + focusNode.data);
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null) {
                System.out.println("key not found");
            }
        }
        return focusNode;
    }


    public boolean remove(int key){
        Node focusNode = root;
        Node parentNode = root;
        Boolean isLeftChild = true;
        while (key !=focusNode.key){
            parentNode = focusNode;
            if (key <focusNode.key){
                isLeftChild=true;
                focusNode=focusNode.left;
            } else{
                isLeftChild=false;
                focusNode=focusNode.right;
            }

            if(focusNode==null){
                return false;
            }

        }

        // no leaf
        if(focusNode.left==null && focusNode.right==null){
            if(focusNode==root){
                root=null;
            }
             else if(isLeftChild){
                parentNode.left=null;
            } else{
                parentNode.right=null;
            }
        } else if (focusNode.left==null){
            if(focusNode==root){
                root=null;
            }
            else if(isLeftChild){

                parentNode.left=focusNode.right;
            } else{
                parentNode.right=focusNode.right;
            }
            }else if (focusNode.right==null){
            if(focusNode==root){
                root=null;
            }
            else if(isLeftChild){

                parentNode.left=focusNode.left;
            } else{
                parentNode.right=focusNode.left ;
            }
            // Two children so I need to find the deleted nodes
            } else {
             Node replacementNode = getReplacementNode(focusNode);
             if(isLeftChild){
                 parentNode.left=replacementNode;
             } else{
                 parentNode.right=replacementNode;

             }
            replacementNode.left=focusNode.left;

            }

        return true;

    }

    public Node getReplacementNode (Node replaced){
        Node focusNode = replaced.right;
        Node focusParent = replaced;
        Node replacementNode =replaced;

        while(focusNode!=null){
            focusParent=replacementNode;
            replacementNode = focusNode;
            focusNode=focusNode.left;
        }
         if(replaced.right!=replacementNode){
             focusParent.left=replacementNode.right;
             replacementNode.right = replaced.right;
         }

        return replacementNode;

    }


    public void traverseBFS(){
        Queue<Node> qu = new LinkedList<Node>();
        if (this.root ==null){
            System.out.println("Tree is empty");
        } else {
            qu.add(this.root);
            while (qu.peek()!=null){
                Node temp = qu.remove();
                System.out.println(temp.data+" ");
                if(temp.left!=null){
                    qu.add(temp.left);

                }
                if(temp.right!=null){
                    qu.add(temp.right);

                }

            }
        }
    }


    public int getHeight(Node root){
        if (root==null){
            return 0;
        }
        return (Math.max(getHeight(root.left),getHeight(root.right)) +1);

    }

    public boolean isBalanced(Node root){
        if (root==null){
            return true;
        }
        int height = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(height) >1){
            return true;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }


    public Node createMinal (int[] arry,int start,int end ){
        if(end<start){
            return null;
        }
        int mid = (start + end)/2;
        Node n = new Node(arry[mid],"");
        n.left = createMinal(arry,0,mid-1);
        n.right=createMinal(arry,mid+1,end);
        return n;
    }


    public  boolean checkBST (Node n){
       return checkBst(n,Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean checkBst (Node n , int max, int min){
        if (n==null){
            return true;
        }
        if ((n.key <= min) || (n.key>max)){
            return false;
        }
        if(!checkBst(n.left,n.key,min) || (!checkBst(n.right,max,n.key))){
            return false;
        }
        return true;
    }

    public class Result {
        Node n;
        Boolean ans;
        public Result(Node n, Boolean ans){
            this.n=n;
            this.ans=ans;
        }
    }




 public Node commonAncestor(Node root, Node p, Node q){
        Result rs =commonsAncestor(root,p,q);
        if(rs.ans){
            return rs.n;
        }
        return null;
    }

    public Result commonsAncestor(Node root, Node p, Node q){
        if(root==null) {
            return new Result(null, false);
        }
        if(root.key==p.key && root.key==q.key){
            return new Result(root,true);
        }
        Result rx = commonsAncestor(root.left,p,q);
        if(rx.ans){
            return rx;
        }
        Result ry = commonsAncestor(root.right,p,q);
                if(ry.ans){
                    return ry;
                }
        if(rx.n!=null && ry.n!=null){
            return new Result(root,true);
        } else {
            if(root.key==p.key || root.key==q.key){
                boolean isAncestor = rx.n != null || ry.n != null ? true : false;
               return new Result(root,isAncestor);
            } else{
                return new Result(rx.n!=null?rx.n:ry.n,false);
            }
        }
    }


    public boolean isSubtree (Node tree, Node subTree){
        if (subTree==null){
            return false;
        }
        return subTree(tree,subTree);
    }
    public boolean subTree(Node tree,Node subTree){
        if (tree==null){
            return false;
        }
        if (tree.key==subTree.key){
            return match(tree,subTree);
        } else{
            return (subTree(tree.left,subTree) || (subTree(tree.right,subTree)));
        }
    }
    public boolean match(Node tree, Node subtree){
        if(tree==null && subtree==null){
            return true;
        }
        if(tree==null || subtree==null){
            return false;
        }
        if(tree.key!=subtree.key){
            return false;
        } return (match(tree.left,subtree.left) && (match(tree.right,subtree.right)));
    }




    public static void main(String arg[]){
        BST bst = new BST();
        bst.addNode(50,"CEO");
        bst.addNode(25,"VP");
        bst.addNode(15,"Office Manager");
        bst.addNode(30,"Secretary");
        bst.addNode(75,"Sales Manager");
        bst.addNode(85,"Salesman");
    //    bst.inOrder(bst.getRoot());
      //  bst.preOrder(bst.getRoot());
        //bst.postOrder(bst.getRoot());

       // bst.remove(25);
      //  System.out.println("deleted 25");
       // bst.inOrder(bst.getRoot());
     //   System.out.println("BFS ");
     //   bst.traverseBFS();
    //    System.out.println("height " + bst.getHeight(bst.root));
   //     System.out.println("isBalanced " + bst.isBalanced(bst.root));
      //int a[] ={1,2,3,4,5,6};
      //  Node newNode = bst.createMinal(a,0,a.length-1);
       //  bst.inOrder(newNode);
        System.out.println("Check BST");
        System.out.println(bst.checkBST(bst.root));
        System.out.printf("Commons Ancestor");
        Node a = bst.commonAncestor(bst.root,new Node(25,"CEO"),new Node(15,"VP"));
        System.out.printf("Node " + a.data);

        BST bst1 = new BST();
        bst.addNode(50,"CEO");
        bst.addNode(25,"VP");
        bst.addNode(15,"Office Manager");
        System.out.println("subtree");
        System.out.println(bst.isSubtree(bst.root,bst1.root)+"");
    }
}


