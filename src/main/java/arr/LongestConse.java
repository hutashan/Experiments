package arr;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConse {
    public static void main(String arg[]){
        int [] arr = {-1,1,0};
        System.out.println(new LongestConse().longestConsecutive(arr));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        if(nums.length==1) return 1;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int maxSoFar=1;
        int longest=1;

        int curr =0;
        for(int i=0;i<nums.length;i++) {
            if (!hs.contains(nums[i] - 1)) {
                longest = 1;

                while (hs.contains(curr + 1)) {
                    curr++;
                    longest++;
                }
            }
            maxSoFar = Math.max(maxSoFar, longest);
        }


        return maxSoFar;
    }
}
