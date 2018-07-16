package G;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String arg[]){
        int[] a1 = {1,2,2,1};
        int []a2 = {2,3};
        new Intersection().intersection(a1,a2);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }
        Set<Integer> hashSet2 = new HashSet<>();
        for (int j : nums2) {
            if (hashSet.contains(j)){
                hashSet2.add(j);
            }
        }
        Integer[] temp =  hashSet2.toArray(new Integer[] {});
        int[] intArray = new int[temp.length];
        for (int i = 0; i < temp.length; i++){
            intArray[i] = temp[i];
        }
        return intArray;
    }
}
