package arr;

import java.util.ArrayList;
import java.util.List;


public class FindMissingArray {

  public static void main(String [] arg){
      int [] arr = {4,3,2,7,8,2,3,1};
      System.out.println(findDisappearedNumbers(arr));

  }





  static  public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
