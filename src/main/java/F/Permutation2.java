package F;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        List<List<Integer>> ls = new Permutation2().permuteUnique(num);
        for (List<Integer> newLS : ls) {
            for (Integer l : newLS) {
                System.out.print(l + " ");
            }
            System.out.println("");

        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
         Arrays.sort(nums);
        permuteUniqueBackTracl( nums, list,new ArrayList<Integer>(),new boolean[nums.length]);
        return list;

    }

    private void permuteUniqueBackTracl(int[] nums, List<List<Integer>> list, ArrayList<Integer> curr, boolean[] used) {
        if(nums.length==curr.size()){
            list.add(new ArrayList<>(curr));
        }else{
            for(int i=0;i<nums.length;i++){
                if(used[i]||i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                curr.add(nums[i]);
                permuteUniqueBackTracl( nums,list,curr, used);
                used[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }



}
