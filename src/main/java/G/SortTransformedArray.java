package G;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class SortTransformedArray {
    public static void main(String arg[]){
        int a = 1, b = 3, c = 5;
        int [] nums = {-4, -2, 2, 4};
        int [] ans = new SortTransformedArray().sortTransformedArray(nums,a,b,c);
        for(int a1 :ans){
            System.out.println(a1);
        }
    }
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums.length==0) return nums;
        TreeSet<Integer> hs = new TreeSet<Integer>();
        int[] ans = new int[nums.length];
        int i=0;
        for(int x :nums){
            ans[i++]=a*x*x+b*x+c;
        }

        Arrays.sort(ans);

        return ans;
    }
}
