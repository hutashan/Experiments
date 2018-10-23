package G;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthElement {
        public static void main(String arg[]){
            int [] arr = {3,2,1,5,6,4} ;
            int k = 2;
            System.out.println(new KthElement().findKthLargest(arr,k));
        }


        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
            PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                 if(o1<o2) return 1;
                 else if(o1>o2) return -1;
                 return 0;
                }
            });
            for (int n : nums){
                q.add(n);
            }
            for(int i=1;i<k;i++){
                q.poll();
            }
            return q.poll();

        }

}
