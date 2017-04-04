package datastructure;


public class DeleteKthFromLast {
    public static void main(String arg[]){
        Node nd = new Node (1);
        nd.append(2);
        nd.append(3);
        nd.append(4);
        nd.append(2);
        nd.append(5);
        Node n2= deleteFromKEnd(nd,4);
        while (n2!=null){
            System.out.printf(n2.data+"");
            n2=n2.next;
        }

    }
    public static Node deleteFromKEnd(Node nd, int k){
        if (nd==null){
            return null;
        }
        Node p1 = nd;
        Node p2 = nd;
        for (int i=0;i<k-1;i++){
            p2 = p2.next;
        }
        while (p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
      return p1;

    }
    public static class Node {
        Node next = null;
        int data;

        public Node(int d){
            data = d;
        }
        void append(int d){
            Node end = new Node(d);
            Node n = this;
            while (n.next!=null){
                n = n.next;
            }
            n.next=end;
        }
        public Node deleteNode(Node head, int d){
            Node n = head;
            if(n.data==d){
                return head.next;
            }
            while(n.next!=null){
                if (n.next.data==d){
                    n.next=n.next.next;
                    return head;
                }
                n = n.next;
            }
            return head;
        }
    }
}
