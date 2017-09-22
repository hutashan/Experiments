package arr;


public class MaximumProdcutSubArray {



    public static void main(String[] args) {

        int[] arr ={-6,4,-5,8,-10,0,8};

        int max=0,min=0;
        int so_far=0;


        for (int i=0;i<arr.length;i++){

            int temp = max;

            max= Math.max(arr[i],Math.max(arr[i]*max,arr[i]*min));
            min = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * min));

         so_far=Math.max(so_far,max);


        }
        System.out.println(so_far);



    }





}
