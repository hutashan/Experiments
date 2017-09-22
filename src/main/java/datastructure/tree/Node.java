package datastructure.tree;

/**
 * Created by v708178 on 8/25/17.
 */
public
    class Node {
        int key;
        String data;
        public  Node left, right;

        public Node(int key, String data) {
            this.data = data;
            this.key = key;
        }
    }


