package F;

public class MedianOfSortedArray {
    public static void main(String[] args) {
        int [] num1={1,12,15,26,38};
        int [] num2 ={2,13,17,30,45};
       // System.out.println(new MedianOfSortedArray().findMedianSortedArrays(num1,num2));
    }
    public void findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==0) ;


    }
    private double medianArray(int [] nums){
        int len=nums.length;
        int half = len/2;
        if(len%2==1){
            return nums[half];
        } else{
            return ((nums[half+1] +nums[half])/2);
        }
    }
}
