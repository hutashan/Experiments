package F;

import datastructure.In;

import java.util.HashMap;

public class MaximumSizeSubarraySum {
    public static void main(String[] args) {
        int [] nums ={1, -1, 5, -2, 3};
        int k =3;
        System.out.println(new MaximumSizeSubarraySum().maxSubArrayLen(nums,k));
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
}
