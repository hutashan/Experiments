package G;

public class RemoveDuplicates {


    public static void main(String arg[]){
        int [] arr = {1,1,2};
        System.out.println(new RemoveDuplicates().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {

        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            } else{
                nums[i+1]=nums[j];
                i++;
            }

        }
        return i+1;
    }
}
