package F;

import java.util.List;

public class Merge2LinkList {
    public static void main(String[] args) {
        Merge2LinkList mr = new Merge2LinkList();
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
        ListNode ls =mr.mergeTwoLists(l1,l2);
        while (l1!=null){
            System.out.println(ls.val);
            ls=ls.next;
        }

    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode(-1);
        ListNode headNode = returnNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                returnNode.next = l1;
                l1 = l1.next;
            } else {
                returnNode.next = l2;
                l2 = l2.next;
            }
            returnNode = returnNode.next;
        }
        if (l1 == null) {
            returnNode.next = l2;
        } else if (l2 == null) {
            returnNode.next = l1;
        }
        return headNode.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val) {
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}
