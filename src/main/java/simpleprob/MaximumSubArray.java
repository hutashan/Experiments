package simpleprob;

/**
 * Created by parmana on 4/21/17.
 */
public class MaximumSubArray {

     static int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};

    public static void main(String[] args) {

        int maxsum=-2;
        int newsum=-2;
        int stposition=0;
        int endposition=0;
        int premaxsum=maxsum;

        for(int i=1;i<arr1.length;i++){
            premaxsum=maxsum;
             newsum= Math.max(newsum+arr1[i],arr1[i]);
            maxsum=Math.max(maxsum,newsum);

            if(premaxsum!=maxsum){
                endposition=i;
            }

            if(newsum>=maxsum && arr1[i]>=newsum ){
                stposition=i;
            }


        }

        System.out.println(maxsum);
        System.out.println(stposition+" , "+endposition);
    }
}
