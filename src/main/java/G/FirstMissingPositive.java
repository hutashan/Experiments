package G;

import datastructure.In;

import java.util.HashSet;

public class FirstMissingPositive {
    public static void main(String arg[]){
        //int [] input = {1,2,3};
         // int [] input  = {3,4,-1,1};
        int [] input  = {7,8,9,11,12};


        System.out.println(new FirstMissingPositive().firstMissingPositive(input));
    }
    public int firstMissingPositive(int[] nums) {
        HashSet <Integer> hs = new HashSet<Integer>();
        int minVal =1;
        if(nums.length==0) return minVal;
        int max =nums[0];
        for(int i=0;i<nums.length;i++){
            if(minVal==nums[i]){
                minVal++;
            }
            hs.add(nums[i]);
        }
        int ans =minVal;
        while(hs.contains(minVal)){
            minVal++;
        }
        return minVal;
    }
}
