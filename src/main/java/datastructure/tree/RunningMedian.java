package datastructure.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void main(String a[]){

        ArrayList<Integer>  arr = new ArrayList<Integer>();
        arr.add(12);
        arr.add(4);
        arr.add(5);
        arr.add(3);
        arr.add(8);
        arr.add(7);


       PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }
        );




       for (int i=0;i<arr.size();i++){
           int n = arr.get(i);
          if((minHeap.size()==0) || (n >minHeap.peek())){
              minHeap.add(arr.get(i));
          } else {
              maxHeap.add(arr.get(i));
          }
           PriorityQueue<Integer>  biggerHeap = null;
           PriorityQueue<Integer>  smallerHeap = null;

           if (minHeap.size()>maxHeap.size()){
               biggerHeap = minHeap;
               smallerHeap = maxHeap;
           } else {
               biggerHeap = maxHeap;
               smallerHeap = minHeap;
           }
           if (biggerHeap.size()- smallerHeap.size()==2) {
               smallerHeap.add(biggerHeap.poll());
           }

           if (biggerHeap.size() > smallerHeap.size()){
               System.out.println((double)biggerHeap.peek());
           } else{
               System.out.println((double)(biggerHeap.peek()+smallerHeap.peek())/2);
           }

       }




    }

}
