package arr;

/**
 * Created by parmana on 9/16/17.
 */
public class FindMaximumSequnceOfOnes {

    public static void main(String[] args) {

        int[] arr ={1,1,0,1,1,0,1,1,1,1,0,0};
        int k=1;
        int count=0;
        int left=0;
        int leftindex=0;
        int window=0;

        for(int right=0;right<arr.length;right++){

            if(arr[right]==0){
                count++;
            }

            while (count>k){

                if(arr[left]==0){
                    count--;
                }
                left++;

            }

            if(right-left+1>window){
                window=right-left+1;
                leftindex=left;
            }


        }


        System.out.println("max sequence "+window +" left "+leftindex +" right "+ (leftindex+window-1));



    }

}
