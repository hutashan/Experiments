package datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by parmana on 2/17/17.
 */
public class PriorityQueueExample {

    public static void main(String[] args) {

        Queue<Integer> queue=new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); // Max heap
               // return o1.compareTo(o2); // min heap
            }
        });

       // Queue<Integer> queue=new PriorityQueue<Integer>();
        queue.add(10);
        queue.add(30);
        queue.add(2);
        queue.add(5);
        //queue.add(3);
        //queue.add(9);
        for(int i:queue){
            System.out.println(i);
        }
        System.out.println(queue.toString());
    }

}
