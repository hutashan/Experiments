package G;

import datastructure.In;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

    public static void main(String arg[]){


        System.out.println(new MergekSortedLists().compareChar("EG","KTP","JrF"));

        ListNode first = new ListNode(1).next =new ListNode(4).next = new ListNode(5);
        ListNode second = new ListNode(1).next =new ListNode(3).next = new ListNode(4);
        ListNode third = new ListNode(2).next =new ListNode(6);




    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((x,y)->(Integer.compare(x.val,y.val)));
        PriorityQueue<ListNode> queue1 = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
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

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            if(tail.next!=null){
                queue.add(tail.next);

            }

        }
        return dummy.next;

    }



    private String compareChar(String start,String end,String query){
        int startLen = start.length();
        int endLen = end.length();
        boolean after = false;
        for(int i=0;i<query.length();i++){
            int queryAsci = query.charAt(i);

            if(i<startLen){
                if(Character.toLowerCase(start.charAt(i))>Character.toLowerCase(query.charAt(i)))
                    return "Before";

            }

        }
        after = true;

        if(after){
            for(int i=0;i<query.length();i++){
                if(i<endLen){
                    if(Character.toLowerCase(end.charAt(i))<Character.toLowerCase(query.charAt(i)))
                        return "after";

                }


            }

        }
        return "inside";




    }

}

