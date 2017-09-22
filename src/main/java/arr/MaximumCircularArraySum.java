package arr;

import ThreadDemo.MyThread1;



public class MaximumCircularArraySum {


    public static void main(String[] args) {

        int[] arr= {2,1,-5,4,-3,1,-3,4,-1};
      //  System.out.println(maxSum(arr));

        int max=maxSum(arr);
        int totalsum=0;

         for(int i:arr){
            totalsum+=i;
         }
        System.out.println(totalsum);

         for (int i=0;i<arr.length;i++){
            arr[i]=-arr[i];
         }

         totalsum+=maxSum(arr);


        System.out.println(max +"  "+ totalsum);

    }






    public static int maxSum(int[] arr){

        int max=arr[0];
        int currentsum=arr[0];

        for(int i=1;i<arr.length;i++){
            currentsum= Math.max(currentsum+arr[i],arr[i]);
            max= Math.max(currentsum,max);

        }
        return max;
    }

}


