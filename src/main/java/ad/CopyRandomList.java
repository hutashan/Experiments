package ad;
import java.util.*;

public class CopyRandomList {

    public static void main(String[] args) {

        Node head1 = new Node(1,null,null);

        Node head2 = new Node(2,null,null);
        head2.random=head2;
        head1.next=head2;
        Node newRe = new CopyRandomList().copyRandomList(head1);
        while(newRe!=null){
            System.out.println(newRe.val);
            newRe=newRe.next;
        }

    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node curr = head;

        while(curr!=null){
            map.put(curr,new Node(curr.val,null,null));
            curr=curr.next;
        }
        curr=head;
        Node resultNode = new Node(0,null,null);
        Node newCurr=resultNode;
        newCurr.next = map.get(curr);
        while(curr!=null){
            newCurr=newCurr.next;
            newCurr.next = map.get(curr.next);
            newCurr.random = map.get(curr.random);
            curr=curr.next;

        }
        return resultNode.next;
    }


   static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

}
