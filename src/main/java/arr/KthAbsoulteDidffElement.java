package arr;


import java.util.Arrays;

public class KthAbsoulteDidffElement {
    public static void main(String ar[]){
       int[] arr= {62,100,4};
        kthAbsDElement(arr,2);
    }

    public static int countPairs(int[] arr,int mid){
        int result =0;
        for (int i=0;i+1<arr.length;i++){

            if(arr[i+1]-arr[i]<=mid){
                result++;
            }
        }
        return result;
    }

    public static void kthAbsDElement(int [] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int high = arr[n-1]-arr[0];
        int low = arr[1]-arr[0];
        for (int i=1;i+1<n;i++){
            low = Math.min(low,(arr[i+1]-arr[i]));
        }
        int mid = (high-low);
        if (k>=arr.length){
            System.out.println(high);
            return;
        }
        while(high>low){
             mid = (high - low);
            if (countPairs(arr,mid)<k){
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        System.out.println("kth element is " +low);
    }
}
