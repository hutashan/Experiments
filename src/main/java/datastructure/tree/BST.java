package datastructure.tree;

public class BST {

    static class Node {
        int key;
        String data;
        Node left, right;

        public Node(int key, String data) {
            this.data = data;
            this.key = key;
        }
    }


    Node root;

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

    public static void main(String arg[]){
        BST bst = new BST();
        bst.addNode(50,"CEO");
        bst.addNode(25,"VP");
        bst.addNode(15,"Office Manager");
        bst.addNode(30,"Secretary");
        bst.addNode(75,"Sales Manager");
        bst.addNode(85,"Salesman");
        bst.inOrder(bst.getRoot());
      //  bst.preOrder(bst.getRoot());
        //bst.postOrder(bst.getRoot());

        bst.remove(25);
        System.out.println("deleted 25");
        bst.inOrder(bst.getRoot());


    }
}


