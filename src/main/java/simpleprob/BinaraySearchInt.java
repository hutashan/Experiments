package simpleprob;

/**
 * Created by parmana on 2/3/17.
 */
public class BinaraySearchInt {
    public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println(binSerach(arr,4,0,arr.length-1));

    }


    public static int binSerach(int[] arr,int searchNum,int low,int high){

         if(low>high) return -1;
         int mid=(low+high)/2;
        if(arr[mid]==searchNum){
            return arr[mid];
        }else if(arr[mid]<searchNum) {
           low=mid+1;
           return binSerach(arr,searchNum,low,high);
        }else {
            high=mid-1;
            return binSerach(arr,searchNum,low,high);
        }


    }

}
