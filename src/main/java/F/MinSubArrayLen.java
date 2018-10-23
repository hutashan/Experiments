package F;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int  s =11;
        int []nums = {1,2,3,4,5};
        System.out.println(new MinSubArrayLen().minSubArrayLen(s,nums));
    }
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int left =0;
        int right=1;
        int sum =nums[left];
        int minCount=Integer.MAX_VALUE;
        int count=0;
        while(left<=right && left<nums.length){
          if(sum>=s ){
              sum=sum-nums[left];
              left++;
              minCount = Math.min(minCount,count);
              if (count>1)count--;
          } else{
              while(sum<=s && right<nums.length){
                  sum=sum+nums[right];
                  right++;
                  count++;

              }

          }

        }
        return Math.min(minCount,count);
    }
}
