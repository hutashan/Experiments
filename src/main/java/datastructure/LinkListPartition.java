package datastructure;

import java.util.Stack;

/**
 *
 2.4 Write code to partition a linked list around a value x
 */
public class LinkListPartition {
    public static class Node {
        Node next = null;
        int data;

        public Node(int d){
            data = d;
        }
        public Node(){

        }
        void append(int d){
            Node end = new Node(d);
            Node n = this;
            while (n.next!=null){
                n = n.next;
            }
            n.next=end;
        }
        void setNextNode(Node newNode){
            Node end = newNode;
            Node n = this;
            while (n.next!=null){
                n = n.next;
            }
            n.next=end;
        }
        void appendCircular(int d,int c){
            Node end = new Node(d);
            Node n = this;
            Node cir = null;
            while (n.next!=null){
                if (c==n.data){
                    cir = n;
                }
                n = n.next;
            }
            end.next=cir;
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

    public static void main(String arg[]){
        Node nd = new Node (1);
        nd.append(9);
        Node n2 = reverseUtil(nd,null);


      //  Node nd2 = new Node(1);
       // nd2.append(2);
      //  Node n2 = addList(nd,nd2,0);



          //   Node n2 = partition(nd,3);
       // isPalidrome(nd);
     //   System.out.printf("dt "+ isPalidrome(nd));
    while (n2!=null){
            System.out.printf(n2.data+"");
            n2 = n2.next;
        }
    }

    public static Node addList (Node n1, Node n2, int carry){
        if (n1==null && n2==null && carry==0){
            return null;
        }
        Node res = null;
        int value = carry;
        if(n1!=null){
            value += n1.data;
        }
        if (n2!=null){
            value +=n2.data;

        }
        if (res==null ){
            res = new Node(value % 10);
        } else {
            res.append(value % 10);
        }
        if(n1!=null || n2!=null ){
            Node newNd = addList(n1==null?null:n1.next,n2==null?null:n2.next,value>=10?1:0);
            res.setNextNode(newNd);

        }
        return res;
    }


    public static Node addListReverse (Node n1, Node n2, int carry){
        if (n1==null && n2==null && carry==0){
            return null;
        }
        Node res = null;
        int value = carry;
        if(n1!=null){
            value += n1.data;
        }
        if (n2!=null){
            value +=n2.data;

        }
        if (res==null ){
            res = new Node(value % 10);
        } else {
            res.append(value % 10);
        }
        if(n1!=null || n2!=null ){
            Node newNd = addList(n1==null?null:n1.next,n2==null?null:n2.next,value>=10?1:0);
            res.setNextNode(newNd);

        }
        return res;
    }

    public static Node reverse (Node nd){
        Node current = nd;
        Node prev = null;
        Node next = null;
        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current=next;
        }
        return prev;
    }

    static Node head;
    static public Node  reverseUtil(Node curr, Node prev) {

        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;
            return null;
        }

        /* Save curr->next node for recursive call */
        Node next1 = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverseUtil(next1, curr);
        return head;
    }




    public static Boolean isPalidrome(Node nd){
        Node fast = nd;
        Node slow =nd;
        Stack<String> st = new Stack<String>();
        while (fast!=null && fast.next!=null){
            st.push(slow.data+"");
            fast = fast.next.next;
            slow = slow.next;

        }
        if (slow==null){
            return null;
        }

        if(fast !=null){
            slow = slow.next;
        }

        while (slow!=null){
            if (!(st.pop().equals(slow.data+""))){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static Node findBegning(Node head){
        Node slow = head;
        Node fast = head;
        while (fast!=null || fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            System.out.println(slow.data +" "+ fast.data);
            if (fast.data==slow.data){
                break;
            }
        }
        if (fast ==null || fast.next==null){
            return null;
        }
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
            System.out.println("second "+slow.data +" "+ fast.data);
        }

        return fast;
    }









    public static Node partition(Node nd , int x){
        Node beforeStart = null;
        Node afterStart = null;
        while (nd != null) {
            Node next = nd.next;
            if (nd.data <x ){
                nd.next = beforeStart;
                beforeStart = nd;
            } else {
                nd.next = afterStart;
                afterStart = nd;
            }
            nd = next;
        }
        if (beforeStart ==null) {
            return afterStart;
        }
        Node head = beforeStart;

        while (beforeStart.next != null) {
            beforeStart = beforeStart.next;
        }
            beforeStart.next = afterStart;
            return head;
    }
}
