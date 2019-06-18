package F;

public class MoveZeroes1 {
    public void moveZeroes(int[] nums) {
        int replaceCounter =-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                replaceCounter=i;
                break;
            }
        }
        if(replaceCounter!=-1){
            for(int i=replaceCounter;i<nums.length;i++){
                if(nums[i]!=0){
                    nums[replaceCounter]=nums[i];
                    replaceCounter++;
                }

            }
            for(int i =replaceCounter;i<nums.length;i++){
                nums[i]=0;
            }
        }


    }
}
