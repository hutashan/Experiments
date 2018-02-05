package arr;


public class MinimumSubArrayOfkSize {


    public static void main(String[] args) {

        int[] arr= {10,4,2,5,6,3,8,1};
        int k=3;

        int windowsum=0;
        int minimumsum=Integer.MAX_VALUE;
        int rightindex=0;


        for(int i=0;i<arr.length;i++){
            windowsum+=arr[i];

            if(i+1>=k){
                if(minimumsum>windowsum){
                    minimumsum=windowsum;
                    rightindex=i+1;
                }
                windowsum-=arr[i-2];
            }
        }

        System.out.println(minimumsum +" left "+(rightindex-k) +" rigght "+ (rightindex-1));

    }
}
