package datastructure;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by parmana on 2/20/17.
 */
public class MyLinkedList {
      Node list =null;

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.add(1);
        obj.add(2);
        obj.add(7);
        obj.add(4);
        obj.add(10);
        obj.add(7);
        obj.dispaly();
    }

    public Node getList(){
        return list;
    }

    public void removeDupWithSet(Node list){
        HashSet<Integer> set= new HashSet<Integer>();
        Node current=list;
        Node previous = list;
        while (current!=null) {
            if (set.contains(current.data)) {
                 previous.next=current.next;


            } else {
                set.add(current.data);
                previous=current;
            }
            current=current.next;
        }
    }


    public void dispaly(){

        while (list!=null){
            System.out.println(list.data);
            list=list.next;
        }

    }


    public  void add(int i){

        if(list!=null){
            Node n= new Node();
            n.data=i;
            n.next=list;
            list=n;
        } else {
            list= new Node();
            list.data=i;
        }

    }

}
