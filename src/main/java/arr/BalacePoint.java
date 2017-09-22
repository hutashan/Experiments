package arr;

/**
 * Created by v708178 on 8/16/17.
 */
public class BalacePoint {



    public static void main(String a[]){
        int[] arr ={1,2,7,10,8,2,-10,-1,11};
        test(arr);
     /*   for (int i=0;i<arr.length;i++){
            int leftSum=0;
            int rightSum=0;
            for(int j=0;j<=i;j++){
                leftSum+=arr[j];
            }
            for (int k=i;k<arr.length;k++){
                rightSum+=arr[k];
            }
            if(leftSum==rightSum){
                System.out.println(i);
            }
        }*/
    }
    public static void test(int[] a){


        int [] leftSum=new int [a.length];
        int [] rightSum=new int [a.length];
        leftSum[0]=a[0];
        rightSum[a.length-1]=a[a.length-1];
        for(int i=1;i<a.length;i++){
            leftSum[i]=leftSum[i-1]+a[i];
            System.out.print(leftSum[i]+" ,");
        }
        System.out.println("right");
        for(int i=a.length-2;i>=0;i--){
            rightSum[i]=rightSum[i+1]+a[i];
            System.out.print(rightSum[i]+" ,");
        }
        System.out.println(rightSum.toString());
        System.out.println(leftSum.toString());
        for(int i=0;i<leftSum.length;i++){
            if (leftSum[i]==rightSum[i]){
                System.out.println(i);
            }
        }


    }
}
