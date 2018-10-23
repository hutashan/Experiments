package F;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class IntersectionArrays {
    public static void main(String[] args) {
    int [] nums1 = { 2,1,1,2}, nums2 = {2,2,};
        int [] res = new IntersectionArrays().intersect(nums1,nums2);
        for(int k : res){
            System.out.println(k);
        }

    }
    public int[] intersect1(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(nums1==null && nums2==null && nums1.length==0 && nums2.length==0){
            return null;
        }
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for(int n : nums1){
            if(hs.containsKey(n)){
                int v = hs.get(n)+1;
                hs.put(n,v);
            } else {
                hs.put(n,1);
            }
        }
        int i=0;
        for(int n : nums2){
            if(hs.containsKey(n) && hs.get(n)!=0){
                arr.add(n);
                int v = hs.get(n)-1;
                hs.put(n,v);
            }
        }
        int [] res = new int[arr.size()];
        for(int a : arr){
            res[i++]=a;
        }
        return res;
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        quickSort(nums1, 0, nums1.length-1);
        quickSort(nums2, 0, nums2.length-1);
        //ArrayList<Integer> list = new ArrayList<Integer>();
        int[] ans = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        int n=0;
        for(int i=0,j=0; i<nums1.length && j<nums2.length;){
            if(nums1[i]==nums2[j]){
                //list.add(nums1[i]);
                ans[n++]=nums1[i];
                i++; j++;
            }else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }

        return Arrays.copyOfRange(ans, 0, n);
    }

    public static void quickSort(int[] nums, int begi, int endi){
        if(begi >= endi)
            return;
        int i=begi, j=endi;
        int tmp = nums[i];
        while(i<j){
            while(j > i && nums[j]>=tmp) j--;
            nums[i] = nums[j];
            while(i < j && nums[i]<=tmp) i++;
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        quickSort(nums, begi, i-1);
        quickSort(nums, i+1, endi);
    }
}
