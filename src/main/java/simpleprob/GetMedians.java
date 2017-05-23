package simpleprob;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by parmana on 2/21/17.
 */
public class GetMedians {

    public static double[] getMedians(int[] array){
        PriorityQueue<Integer> lower = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -1*o1.compareTo(o2);
            }
        }) ;
        PriorityQueue<Integer> higher = new PriorityQueue<Integer>();
        double[] medians = new double[array.length];
        for(int i=0;i<array.length;i++) {

            addNumber(higher, lower,array[i] );
            reblance(higher,lower);
            medians[i]=getMedian(higher,lower);


        }
       return medians;
    }

    public static void addNumber(PriorityQueue<Integer> higher,PriorityQueue<Integer> lower,int number){

    }

    public  static  void reblance(PriorityQueue<Integer> higher,PriorityQueue<Integer> lower){

        PriorityQueue<Integer> bigger = lower.size()>higher.size()?lower:higher;
        PriorityQueue<Integer> smaller = lower.size()>higher.size()?higher:lower;

        if(bigger.size()-smaller.size()>=2){
            smaller.add(bigger.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> higher,PriorityQueue<Integer> lower){

        PriorityQueue<Integer> bigger = lower.size()>higher.size()?lower:higher;
        PriorityQueue<Integer> smaller = lower.size()>higher.size()?higher:lower;

        if(bigger.size()==smaller.size()){
            return (double) (bigger.peek()+lower.peek())/2;
        } else {

          return bigger.peek();
        }

    }

}
