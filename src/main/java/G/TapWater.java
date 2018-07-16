package G;

public class TapWater {
    public static void main(String arg[]){
        int [] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TapWater().trap(input));

    }

    public int trap(int[] height) {
        int[] leftHieght=new int[height.length];
        int[] rightHieght=new int[height.length];
        leftHieght[0]=height[0];
        for (int i=1;i<height.length;i++){
            leftHieght[i]=Math.max(leftHieght[i-1],height[i]);
        }
        rightHieght[height.length-1]=height[height.length-1];
        int len = height.length-2;
        for (int i= len;i>=0;i--){
            rightHieght[i]=
                    Math.max(rightHieght[i+1],height[i]);
        }
        int total=0;
        for (int i=0;i<height.length;i++){
            total = total+ Math.max(rightHieght[i],leftHieght[i])-height[i];
        }
        return total;

    }
}
