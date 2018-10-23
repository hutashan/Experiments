package F;

public class ReverseList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1).
                next=new ListNode(2).
                next=new ListNode(3).next=new ListNode(4).next=new ListNode(5);

        ListNode root1= new ReverseList().reverseList(root);
        while(root!=null){
            System.out.println(root.val);
            root=root.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode previous=null;
        ListNode current=head;

        while(current!=null){
            ListNode next=current.next;
            current.next=previous;
            previous=current;
            current=next;

        }

        return previous;

    }
}
