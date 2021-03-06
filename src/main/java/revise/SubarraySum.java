package revise;
import java.util.*;
public class SubarraySum {
    public static void main(String[] args) {
        int [] input = {1,2,3};

        System.out.println(new SubarraySum().subarraySum(input,3));
    }
    public int subarraySum(int[] a, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum-k);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        return count;
    }

}
