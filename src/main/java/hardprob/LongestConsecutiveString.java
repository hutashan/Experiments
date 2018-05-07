package hardprob;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestConsecutiveString {
    public static void main(String arg[]){
        int [] arr= {100, 4, 200, 1, 3, 2};
        System.out.println();

    }
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max_so_far =0;
        int max =0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]<nums[i-1]){
               max=max+1;
            }
            max_so_far = Math.max(max,max_so_far);

        }

        return max_so_far;
    }

}

