package arr;


import datastructure.In;

import java.util.HashMap;
import java.util.HashSet;

public class SubArraySum {
    public static void main(String a[]){
        int[] A1 = {-8, 1, 7, 6, 10, 45};
      //  subArrSumHashing(A1,16);
        subArrSumWindow(A1,16);
    }
    public static void subArrSumHashing(int[] arr,int sum) {
        HashMap<Integer,Integer> hs = new HashMap<Integer, Integer>();
        int totalSum =0;
        for (int i=0;i<arr.length;i++){
            totalSum = totalSum+arr[i];
            if (hs.containsKey(totalSum-sum)){
                int index = hs.get(totalSum-sum)+1;
                System.out.println("found " + index + "  " + i );
            } else {
               hs.put(totalSum,i);
            }
        }

    }
    public static void subArrSumWindow(int[] arr,int sum) {
        int totalSum = 0;

        int rightIndex =0;
        for (int leftIndex=0;leftIndex<arr.length;leftIndex++){
            while(totalSum<sum && rightIndex<arr.length){
                totalSum = totalSum + arr[rightIndex];
                rightIndex++;
            }
            if (totalSum==sum){
                System.out.println("found from  " + leftIndex + " to " + rightIndex);
            }
            totalSum = totalSum-arr[leftIndex];
        }
    }
}
