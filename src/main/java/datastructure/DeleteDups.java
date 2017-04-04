package datastructure;

/*
   Write code to remove duplicates from an unsorted linked list.

 */

import java.util.Hashtable;
import java.util.LinkedList;

public class DeleteDups {
    public static void main(String arg[]){
       Node nd = new Node (1);
        nd.append(2);
        nd.append(3);
        nd.append(4);
        nd.append(2);
        nd.append(5);


        Node n1 = deleteDup(nd);
        deleteDupNoBuffer(n1);


    }
    public static Node deleteDup(Node nd){
        Hashtable hs = new Hashtable<Integer,Boolean>();
        Node prev = null;
        while(nd!=null){
            if (hs.containsKey(nd.data)){
                prev.next = prev.next;
            } else{
                hs.put(nd.data,true);
                prev=nd;
            }
            nd = nd.next;
        }
        return nd;
    }

    public static void deleteDupNoBuffer(Node nd){
        if (nd == null) {
            return;
        }
        Node current = nd;
        while(current !=null){
            Node runner = current;
            while (runner.next!=null)
                if(runner.next.data==current.data){
                runner.next=runner.next.next;
            }else{
                runner=runner.next;
            }
            current=current.next;

        }
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
