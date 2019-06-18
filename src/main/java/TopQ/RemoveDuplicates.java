package TopQ;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
      //  int [] nums ={1,1,2};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));

    }
    public int removeDuplicates(int[] nums) {
        int left =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                nums[left+1]=nums[i];
                left=left+1;

            }
        }

       // for(int j=0;j<left+1;j++){
         //   System.out.println(nums[j]);
       // }


        return left +1;
    }
}

