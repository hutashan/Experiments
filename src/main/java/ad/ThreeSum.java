package ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int [] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ThreeSum().threeSum(num);
        for(List<Integer> ls : res){
            System.out.println(ls);
        }

    }
    public List<List<Integer>> threeSum(int[] num) {
        if(num==null || num.length==0) return null;
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<num.length;i++){
            if(i==0 || i>0 && num[i]!=num[i-1]) {
                int lo = i + 1;
                int hi = num.length-1;
                int sum = 0 - num[i];
                while(lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        result.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else {
                        if (num[lo] + num[hi] < sum) {
                            lo++;
                        } else {
                            hi--;
                        }
                    }
                }

            }
        }
        return result;

    }

}
