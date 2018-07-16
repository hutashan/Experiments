package G;

import datastructure.In;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

    public static void main(String arg[]){
        ListNode first = new ListNode(1).next =new ListNode(4).next = new ListNode(5);
        ListNode second = new ListNode(1).next =new ListNode(3).next = new ListNode(4);
        ListNode third = new ListNode(2).next =new ListNode(6);




    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val>o2.val){
                    return -1;
                } else if(o1.val==o2.val){
                    return 0;
                } else{
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for(ListNode node: lists){
           if(node!=null){
               queue.add(node);
           }
        }

        while(queue!=null){
            tail.next=queue.poll();
            tail=tail.next;
            if(tail!=null){
                queue.add(tail);

            }

        }
        return dummy.next;

    }
}

