package F;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        ListNode  l12 = new ListNode(2);
        l1.next =  l12;
        ListNode  l13=new ListNode(4);
        l12.next=l13;

        ListNode l2 = new ListNode(1);

        ListNode l22=       new ListNode(3);
        ListNode l23=new ListNode(4);
        l2.next=l22;
        l22.next=l23;
        MergeTwoLists m = new MergeTwoLists();
        ListNode ls =m.mergeTwoLists(l1,l2);
        while (l1!=null){
            System.out.println(ls.val);
            ls=ls.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                System.out.println("val l1"+l1.val);
                System.out.println("val l2"+l2.val);
                curr.next = l1;
                l1=l1.next;
            }
            else{
                curr.next=l2;
                l2=l2.next;
            }
            curr = curr.next;

        }

        if(l1==null) curr.next=l2;
        else if(l2==null) curr.next=l1;

        return dummy.next;
    }



}

