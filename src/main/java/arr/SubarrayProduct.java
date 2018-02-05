package arr;


public class SubarrayProduct {
    public static void main(String arg[]) {
        int[] arr = {10, 5, 2, 6};
        int k = 100;
    }

    public void numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int product = 1;
        int starting = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] < k) {
                System.out.println(nums[i]);
                if (product * nums[i] < k) {
                    product = product * nums[i];
                    count = count + 1;
                    i++;
                } else {
                    while (product / nums[starting] < 100) {
                        product = product / nums[starting];
                    }
                }

            }

        }

    }
}
