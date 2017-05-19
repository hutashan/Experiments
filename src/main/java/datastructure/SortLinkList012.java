package datastructure;

public class SortLinkList012 {
    public static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }

        public Node() {

        }

        void append(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        void setNextNode(Node newNode) {
            Node end = newNode;
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        void appendCircular(int d, int c) {
            Node end = new Node(d);
            Node n = this;
            Node cir = null;
            while (n.next != null) {
                if (c == n.data) {
                    cir = n;
                }
                n = n.next;
            }
            end.next = cir;
            n.next = end;


        }
    }
    public static void main(String a[]){
        Node n = new Node(0);
        n.append(2);
        n.append(1);
        n.append(2);
        n.append(0);
        n.append(1);
        n.append(0);
        n.append(1);
        Node newNode = shortLinkList(n);
        while (newNode!=null){
            System.out.println(newNode.data);
            newNode = newNode.next;
        }
    }
    static Node shortLinkList(Node nd){
        Node nodeMain0= null;
        Node nodeMain1= null;
        Node nodeMain2= null;
        Node next0 = null;
        Node next1 = null;
        Node next2 = null;
        while (nd!=null){
            if (nd.data==0){
                if (nodeMain0==null){
                    nodeMain0 = new Node(0);
                    next0 = nodeMain0;
                } else {
                    next0.next = new Node(0);
                    next0 = next0.next;
                }
            } else if (nd.data==1){
                if (nodeMain1==null){
                    nodeMain1 = new Node(1);
                    next1 = nodeMain1;
                } else {
                    next1.next = new Node(1);
                    next1 = next1.next;
                }
            }else if (nd.data==2){
                if (nodeMain2==null){
                    nodeMain2 = new Node(2);
                    next2 = nodeMain2;
                } else {
                    next2.next = new Node(2);
                    next2 = next2.next;
                }
            }
            nd = nd.next;
        }
        Node head = nodeMain0;
        next0.next = nodeMain1;
        next1.next = nodeMain2;
        return head;
    }

}
