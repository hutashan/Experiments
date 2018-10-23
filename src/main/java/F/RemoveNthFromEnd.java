package F;

public class RemoveNthFromEnd {
   static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        ListNode head =  new ListNode(1);
        ListNode head2 =new ListNode(2);
        head.next=head2;
        ListNode head3 =new ListNode(3);
      //  head2.next=head3;
        ListNode head4 =new ListNode(4);
        head3.next=head4;
        ListNode head5 =new ListNode(5);
        head4.next=head5;
        ListNode headRes = new RemoveNthFromEnd().removeNthFromEnd(head,1);
        while(headRes!=null){
            System.out.println(headRes.val+",");
            headRes=headRes.next;
        }


    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode p1=head,p2=head;
        while(n>=0 && p2!=null){
            p2=p2.next;
            n--;
        }
        //     if(p2==null && n!=0) return head;
        while(p2!=null){
            p2=p2.next;
            p1=p1.next;
        }
        if(p1==head && n==0){
            head=head.next;
            return head;
        }
        if(p1.next!=null) {
            p1.next = p1.next.next;
        } else
        {
            return null;
        }
        return head;
    }


}
