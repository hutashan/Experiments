package a;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int [] input = {1,2,3,4};
        int [] output = new ProductExceptSelf().productExceptSelf(input);
        for (int i : output){
            System.out.println(i);
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int [] output = new int[nums.length];
        output[0]=1;
        for(int i=1;i<output.length;i++){
            output[i]= output[i-1]*nums[i-1];
        }
        int right =1;

        for(int i=output.length-1;i>=0;i--){
            output[i]= output[i]*right ;
            right=right*nums[i];

        }
        return output;
    }
}
