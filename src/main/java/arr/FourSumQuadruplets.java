package arr;

/**
 * Created by parmana on 9/10/17.
 */
public class FourSumQuadruplets {


    public static void main(String[] args) {
        int[] arr={2,7,4,0,9,5,1,3};
        System.out.println(fourSumQuadruplets(arr,arr.length,20,0));
    }



    public static boolean fourSumQuadruplets(int[] arr,int n,int sum,int count){

        if(sum==0 && count==4)
            return true;

        if(count>4||n==1)
            return false;

        return fourSumQuadruplets(arr,n-1,sum-arr[n-1],count+1)|| fourSumQuadruplets(arr,n-1,sum,count);



    }

}
