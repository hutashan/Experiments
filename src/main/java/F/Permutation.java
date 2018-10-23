package F;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        List<List<Integer>> ls = new Permutation().permute(num);
        for (List<Integer> newLS : ls) {
            for (Integer l : newLS) {
                System.out.print(l + " ");
            }
            System.out.println("");

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(nums);
        permuteBackTrach( nums, list,new ArrayList<Integer>());
        return list;

    }
    public void permuteBackTrach(int[] nums , List<List<Integer>> res,List<Integer> curr) {
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));

        } else{
            for(int j=0;j<nums.length;j++){
                if(curr.contains(nums[j])) continue;;
                curr.add(nums[j]);
                permuteBackTrach(nums,res,curr);
                curr.remove(curr.size()-1);

            }
        }

    }


    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
