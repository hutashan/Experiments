package G;

import java.util.HashSet;
import java.util.TreeSet;

public class KEmptySlot {
    public static void main(String arg[]){
        int[] flower = {1,3,2};
        int k=1;
        System.out.println(new KEmptySlot().kEmptySlots(flower,k));

    }
    public int kEmptySlots1(int[] flowers, int k) {
        TreeSet<Integer> active = new TreeSet<Integer>();
        int day = 0;
        for (int flower : flowers){

            day ++;
            active.add(flower);
            Integer lower = active.lower(flower);
            Integer higher = active.higher(flower);
            if ((lower!=null && flower-lower-1==k) || (higher!=null && higher-flower-1==k)){
                return day;
            }

        }
        return -1;
    }

    public int kEmptySlots(int[] flowers, int k) {
        int[] days =  new int[flowers.length];
        for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for(int i = 0; right < days.length; i++){
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i;
                right = k + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE)?-1:res;
    }

}
