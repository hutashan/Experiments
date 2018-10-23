package F;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] num = {-2,0,1,1,2};
        List<List<Integer>> s = new ThreeSum().threeSum(num);
        for (List<Integer> ls : s) {
            for (int i : ls) {
                System.out.print(i +",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // if (nums[i] > 0) break;
            twosum(nums, i+1, -nums[i], result);
        }
        return result;
    }

    private void twosum(int[] nums, int start, int target, List<List<Integer>> result) {
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] == target) {
                result.add(Arrays.asList(-target, nums[lo], nums[hi]));
                lo++;
                hi--;
                while (lo < hi && nums[lo] == nums[lo-1]) lo++;
                while (lo < hi && nums[hi] == nums[hi+1]) hi--;
            } else if (nums[lo] + nums[hi] > target) {
                hi--;
            } else {
                lo++;
            }
        }
    }
}
