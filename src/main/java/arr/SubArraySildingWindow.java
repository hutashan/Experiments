package arr;

public class SubArraySildingWindow {

    public static void main(String arg[]){
        int[] A1 = {8, 1, 7, 6, 10, 45};
       // findMaxSubarraySum(A1,6);
   //     findSmallestSubArrWithGivenSum(A1,10);
        int[] A2 = {1, 0, 1, 0, 1,1};
        findContinuous1SubArray(A2,2);
    }


    static void findContinuous1SubArray(int arr[] , int k){
            // 1,0,1,0,1,1,1
        int left =0;
        int right =0;
        int window =0;
        int leftMax =0;
        int countZero =0;
        int rightMax=0;
        for (right =0; right<arr.length;right++){
            if (arr[right]==0){
                countZero ++;
            }
            while (countZero>k) {
                if (arr[left]==0){
                    countZero --;
                }
                left++;
            }
                if (window<right-left+1) {
                    window = right - left + 1;
                    leftMax = left;
                    rightMax = right;
                }
            }


        System.out.println("sub array found from " + leftMax + " to "+ rightMax );


    }






    static void findSmallestSubArrWithGivenSum(int arr[],int sum){
        int left =0;
        int right=0;
        int widowSum =0;
        int len =Integer.MAX_VALUE;
        for (right=0;right<arr.length;right++){
            widowSum +=arr[right];
            while(widowSum>sum && left<=right){
                len = Math.min(len,right-left+1);
                widowSum -=arr[left];
                left++;

            }
        }
        System.out.println(len);
    }

    static void findMaxSubarraySum(int arr[], int sum){
        int rightIndex =0;
        int currentSum_so_far =0;
        int maxSum =0;
        int leftSoFar =0;
         int leftIndex =0;
        int rightSofar =0;
        for ( leftIndex=0 ;leftIndex<arr.length;leftIndex++ ){
            while(currentSum_so_far<sum && rightIndex<arr.length){
                currentSum_so_far = currentSum_so_far+arr[rightIndex];
                rightIndex++;

            }
            if (maxSum<currentSum_so_far && sum>currentSum_so_far){
                maxSum=currentSum_so_far;
                leftSoFar = leftIndex;
                rightIndex = rightSofar;
            }

            currentSum_so_far=currentSum_so_far-arr[leftIndex];
            leftIndex ++;


        }
        if (maxSum<currentSum_so_far){
            maxSum=currentSum_so_far;
            leftSoFar = leftIndex;
            rightIndex = rightSofar;
        }
        System.out.println("Sum is  " + maxSum + " from " + leftSoFar +" to " + rightIndex);


    }

}
