package F;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int [] num ={1,2,3};
        List<List<Integer>> ls = new Subsets().subsets(num);
        for(List<Integer> newLS : ls){
            for(Integer l : newLS){
                System.out.print(l +" ");
            }
            System.out.println("");

        }
    }





    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsBackTrack(0,nums,new ArrayList<Integer>(),res );
        return res;
    }

    public void subsetsBackTrack(int index,int[] nums,List<Integer> curr,List<List<Integer>> res){

        res.add(new ArrayList<>(curr));
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            subsetsBackTrack(i+1,nums,curr,res);
            curr.remove(curr.size()-1);

        }

    }







    public void subsetsRecurssion(int[] nums,int index,List<Integer> curr,List<List<Integer>> res) {
        res.add(curr);
        for(int i = index;i<nums.length;i++){
            List<Integer> tmp = new ArrayList<>(curr);
            tmp.add(nums[i]);
            subsetsRecurssion(nums,i+1,tmp,res);
        }

    }
    public void addToSet(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        res.add(curr);
        for (int i = index; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(curr);
            temp.add(nums[i]);
            addToSet(i+1, nums, temp, res);
        }
    }

}
