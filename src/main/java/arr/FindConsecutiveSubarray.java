package arr;

/**
 * Created by parmana on 9/18/17.
 */

public class FindConsecutiveSubarray {

    public static void main(String[] args) {


        int[] arr= {1,56,58,57,90,92,94,93,91,41};
        int min=0,max=0,len=0,st=0,end=0;

           for(int i=0;i<arr.length;i++){

               min=arr[i];max=arr[i];

               for (int j=i+1;j<arr.length;j++){
                     min =Math.min(min,arr[j]);
                     max= Math.max(max,arr[j]);
                    if(max-min==j-i){
                        if(len<max-min+1){
                            st=i;
                            end=j;
                        }
                        len= Math.max(len,max-min+1);

                    }
             }
 }

        System.out.println(len +" st "+st +" end "+end);


    }

}
