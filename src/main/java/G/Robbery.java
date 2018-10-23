package G;

public class Robbery {

    public static void main(String[] args) {
        int [] num = {1,2,3,4,5,6,2};
        System.out.println(new Robbery().rob(num));
    }
    private int rob1(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }


    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int a = 0, b = 0;

        for (int i=0; i<nums.length-1; i++) {
            if (i % 2 == 0) {
                a = Math.max(b, a + nums[i]);
            } else {
                b = Math.max(a, b + nums[i]);
            }
        }

        int max = Math.max(a, b);
        a=0; b=0;

        for (int i=1; i<nums.length; i++) {
            if (i % 2 == 0) {
                a = Math.max(b, a + nums[i]);
            } else {
                b = Math.max(a, b + nums[i]);
            }
        }

        max = Math.max(max, Math.max(a,b));

        return max;
    }
}
