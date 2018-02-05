package arr;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SumOfArrays {

    public static void main(String a[]){
        int[] A = {-8, 1, 4, 6, 10, 45};
        // sumOf2UsingHashMap(A,5);
        //sumOf2UsingSorting(A,5);
      //  threeSomeUsingHashMap(A,11);
       // threeSomeUsingSorting(A,11);

      // given sum is zero

        int[] A1 = {-8, 1, 7, 6, 10, 45};
      //  threeSomeUsingHashMap(A1,0);
        // threeSomeUsingSorting(A1,0);

        // sum of 4 with n2

        fourUsingSorting(A1,15);

    }

    public static void fourUsingSorting(int[] arr,int sum) {
        int [] newArr =  new int [(arr.length)*(arr.length-1)/2];
        HashMap<Integer,ArrayList<Integer>>  hs = new HashMap<Integer, ArrayList<Integer>>();
        int k=0;
        for (int i =0;i<arr.length-1;i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(i);
                al.add(j);
                hs.put(arr[i] + arr[j], al);
                newArr[k]=arr[i] + arr[j];
                k++;
            }
        }
        Arrays.sort(newArr);
        int i =0,j = newArr.length-1;
        while(i<j){
            if (sum==newArr[i]+newArr[j]){
                ArrayList <Integer> first = hs.get(newArr[i]);
                ArrayList <Integer> second = hs.get(newArr[j]);
                if (first.get(0)!=second.get(0) && first.get(0)!=second.get(1) && first.get(1)!=second.get(0) && first.get(1)!=second.get(1)){
                    System.out.println(arr[first.get(0)] +" "+arr[first.get(1)] +" "+arr[second.get(0)] +" " +arr[second.get(1)] +" " );
                    break;
                 }
            } else{
                if (newArr[i]+newArr[j]<sum){
                    i++;
                } else{
                    j--;
                }
            }
        }


    }


    public static void threeSomeUsingSorting(int[] arr,int sum) {
        Arrays.sort(arr);
        for (int k =0;k<arr.length-2;k++){
            int i =k+1;
            int j = arr.length-1;
            while(i<j){
                if(arr[k]+arr[i]+arr[j]==sum){
                    System.out.println(arr[k] + " " + arr[i] + " " + arr[j]);
                    i++;
                   // break;
                } else {
                    if (arr[k]+arr[i]+arr[j]<sum){
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }




    }





    public static void threeSomeUsingHashMap(int[] arr,int sum) {
        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<Integer, ArrayList<Integer>>();
        for (int i=0;i<arr.length;i++){
           for(int j=i+1;j<arr.length;j++) {
               ArrayList<Integer> aL = new ArrayList<Integer>();
               aL.add(i);
               aL.add(j);
               hs.put(arr[i] + arr[j], aL);
           }
        }
        for (int i=0;i<arr.length;i++){
            if (hs.containsKey(sum-arr[i])){
               ArrayList<Integer> arr1 =  hs.get(sum-arr[i]);
                if ( !(arr1.get(0)==i || arr1.get(1)==i)) {
                    System.out.println(arr[arr1.get(0)] + " " + arr[arr1.get(1)] + " " + arr[i]);
                    // break;
                }
            }
        }

    }






    public static void sumOf2UsingHashMap(int[] arr,int sum) {
        HashMap<Integer,Integer> hs = new HashMap<Integer, Integer>();
       // we can use set as well
        for (int i=0;i<arr.length;i++){
            hs.put(arr[i],arr[i]);
        }

        for (int i=0;i<arr.length;i++){
            if (hs.containsKey(sum-arr[i])){
                System.out.println(hs.get(sum-arr[i]) + " ,"+ arr[i]);
            }
        }
    }

    public static void sumOf2UsingSorting(int[] arr,int sum) {
        Arrays.sort(arr);
       int i =0;
        int j = arr.length-1;
       while(i<j)
           if (arr[i]+arr[j]==sum){
               System.out.println(arr[i] + " " +arr[j]);
               break;
           } else {
               if (arr[i] + arr[j] < sum) {
                   i++;
               } else {
                   j--;
               }
           }


    }


}

