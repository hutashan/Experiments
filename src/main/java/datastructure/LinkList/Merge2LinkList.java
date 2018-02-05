package datastructure.LinkList;


import collections.HashMapExample;

import java.util.HashMap;

public class Merge2LinkList {
    public static void main(String arg[]){

        Node root1 = new Node(1);
        root1.append(3);
        root1.append(8);
        Node root2 = new Node(2);
        root2.append(5);
        Node mergeRoot =merge2SortedList(root1,root2);
        while (mergeRoot!=null){
            System.out.printf(mergeRoot.data+" ");
            mergeRoot=mergeRoot.next;
        }



    }
   public static Node merge2SortedList(Node root1,Node root2){
       Node currA = root1;
       Node currB = root2;
       Node previous =null;
       Node temp = null;
       while(currA!=null && currB!=null)
       if(currA.data<currB.data){
           previous = currA;
           currA=currA.next;
       } else{
           temp=currB;
           currB=currB.next;
           temp.next=currA;
           previous.next=temp;
           previous = previous.next;
       }

       return root1;
    }
}
