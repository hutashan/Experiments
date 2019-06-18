package a;

import java.util.HashMap;

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        if (nums == null || nums.length==0) {
            return new int[0];
        }
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int required = target-nums[i];
            if(map.containsKey(required) && i!=map.get(required)) {
                res[0]=i;
                res[1]=map.get(required);
                return res;

            }
        }

        return res;

    }




}
