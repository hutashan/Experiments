package ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSumClosest {
    public static void main(String[] args) {
        int [] input = {-1, 2, 1, -4};
        System.out.println(new ThreeSumClosest().threeSumClosest(input,1));

    }


    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
    }


