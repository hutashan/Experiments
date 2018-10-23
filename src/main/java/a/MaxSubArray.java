package a;

public class MaxSubArray {
    public static void main(String[] args) {
        int [] input = {-2,1,-3,4,-1,2,1,-5,4};
       // int [] input ={1,2};
        System.out.println(new MaxSubArray().maxSubArray(input));
    }
    public int maxSubArray(int[] nums) {
        if(nums==null|| nums.length==0) return 0;
        int gobalMax = Integer.MIN_VALUE;
        int max =nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = max+nums[i];
            if(nums[i]>max && nums[i]> temp){
                max=nums[i];
            } else{
                max=temp;
            }
            gobalMax=Math.max(max,gobalMax);
        }
        return gobalMax;
    }
}
