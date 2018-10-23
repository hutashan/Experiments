package a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int [] imput = {3,2,4};
        int [] output = new TwoSum().twoSum(imput,6);
        for(int v : output){
            System.out.println(v);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];

        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        if (nums == null || nums.length==0) {
            return new int[0];
        }
        for(int i=0;i<nums.length;i++){
            hs.put(nums[i],i);
        }


        for(int i=0;i<nums.length;i++){
            int r = target-nums[i];
            if(hs.containsKey(target-nums[i]) && i!=hs.get(target-nums[i])) {
                res[0]=i;
                res[1]=hs.get(target-nums[i]);
                return res;
            }
        }
        return res;
    }
}
