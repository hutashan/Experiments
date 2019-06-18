package F;

public class MoveZeroes {

    public static void main(String[] args) {
    int [] Input = {1,1,0,3,12};
        new MoveZeroes().moveZeroes(Input);
    }

    public int [] moveZeroes(int[] nums) {
        if(nums==null && nums.length==0) return nums;
        int count =0;
        for(int n : nums){
            if (n!=0) nums[count++]=n;
        }
        while(nums.length>count){
            nums[count++]=0;
        }
        for(int n : nums){
            System.out.println(n);
        }
        return nums;

    }
}
