package F;

import datastructure.In;

import java.util.HashMap;

public class MaximumSizeSubarraySum {
    public static void main(String[] args) {
        int [] nums ={3,1, -1, 5, -2, 3,-3};
        int k =3;
        //System.out.println(new MaximumSizeSubarraySum().maxSubArrayLen(nums,k));
        System.out.println(reverseString("hutashan"));
    }


    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        int sum =0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            if(sum==k){
                max=Math.max(max,i+1);
            }
            int diff = sum-k;
            if(hs.containsKey(diff)){
                max=Math.max(max,i-hs.get(diff));

            }
            if(!hs.containsKey(sum)){
                hs.put(sum,i);
            }
        }
        return max;

    }
    public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
