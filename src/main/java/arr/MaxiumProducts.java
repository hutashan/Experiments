package arr;

public class MaxiumProducts {
    public static void main(String arg[]) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(new MaxiumProducts().maxProduct(arr));

    }

    public int maxProduct(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int max =nums[0];
        int minVal=nums[0];
        int maxVal=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            maxVal = Math.max(nums[i], maxVal * nums[i]);
            minVal = Math.min(nums[i], minVal * nums[i]);


            if (max < maxVal) {
                max = maxVal;
            }
        }
        return max;

    }

}