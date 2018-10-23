package G;

import java.util.Arrays;

public class SmallestDistancePair {
    public static void main(String[] args) {
        int [] num = {1,7,10,25,26,27,27};
        System.out.println(new SmallestDistancePair().smallestDistancePair(num,1));

    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) {
                    int v=nums[right];
                    int u=nums[left];

                    left++;
                }
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
}
