package G;

public class MaxConsecutiveOnes {
    public static void main(String arg[]){
        int[] input = {1,0,1,1,0,1,1,1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(input));
    }
    public int findMaxConsecutiveOnes1(int[] nums) {
        if(nums.length==0) return 0;
        int gobal_Max =0;
        int local_max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                local_max++;
            } else{
                gobal_Max = Math.max(gobal_Max,local_max);
                local_max=0;
            }
        }
        return Math.max(gobal_Max,local_max);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int marker =0;
        int gobal=0;
        int local=0;
        int numberOfO=1;
        boolean firstTime = false;
        for(int i=0;i<nums.length;i++){
            if(firstTime && nums[i]==1){
                marker++;
            }
                if(nums[i]==1){
                    local++;
                } else{
                    if(numberOfO==1){
                        numberOfO--;
                        local++;
                        firstTime=true;
                    }
                    else {
                        gobal = Math.max(gobal, local);
                        local=marker+1;
                        marker=0;
                       // numberOfO++;

                    }

                }
            }



        return gobal = Math.max(gobal, local);
    }





}
