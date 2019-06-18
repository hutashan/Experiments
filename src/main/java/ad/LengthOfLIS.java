package ad;

import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String[] args) {
        int [] nums ={10,9,2,5,3,7,101,18};
        System.out.println(new LengthOfLIS().lengthOfLIS(nums));
        String s = new String();


    }

    public int lengthOfLIS1(int[] nums) {
        if(nums.length==0) return 0;
        int [] dp = new int [nums.length];
        dp[0]=1;
        int maxAns =1;
        for(int i=1;i<dp.length;i++){
            int maxVal =0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    maxVal = Math.max(maxVal,dp[j]);
                }
                dp[i]=maxVal+1;
            }
            maxAns = Math.max(maxAns,dp[i]);
        }
        return maxAns;

    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }




}
