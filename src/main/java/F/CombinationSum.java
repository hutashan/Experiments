package F;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] num = {2,3,6,7};
        List<List<Integer>> ls = new CombinationSum().combinationSum(num,7);
        for (List<Integer> newLS : ls) {
            for (Integer l : newLS) {
                System.out.print(l + " ");
            }
            System.out.println("");

        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumBackTrach( candidates, list,new ArrayList<Integer>(),0,target);
        return list;
    }

    public void combinationSumBackTrach(int[] nums , List<List<Integer>> res,List<Integer> curr,int index,int target) {
        if(target<0) return;
        else if(target==0){
            res.add(new ArrayList<>(curr));

        } else{
            for(int j=index;j<nums.length;j++){

                curr.add(nums[j]);
                combinationSumBackTrach(nums,res,curr,j,target-nums[j]);
                curr.remove(curr.size()-1);

            }
        }

    }
}
