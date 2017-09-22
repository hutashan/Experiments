package arr;

/**
 * Created by parmana on 8/16/17.
 */
public class BlancePointInArray {


    public static void main(String[] args) {

        int [] aa ={1,2,7,10,2,8};



        for(int i=0;i<aa.length;i++){

            int lefSum=0;
            int rightSum=0;
            for(int j=0;j<=i;j++){

                lefSum=lefSum+aa[j];
            }
            for(int j=i;j<aa.length;j++){

                rightSum=rightSum+aa[j];
            }

            if(lefSum==rightSum){
                System.out.println("Index "+ i +" "+ lefSum +" "+rightSum);
            }


        }



    }


    public void improve(int[] aa){

    }
}
