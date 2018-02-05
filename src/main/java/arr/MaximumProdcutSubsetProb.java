package arr;

import java.util.Stack;


public class MaximumProdcutSubsetProb {

    static  int max=Integer.MIN_VALUE;
   static Stack<Integer> set = new Stack<Integer>() ;


    public static void main(String[] args) {
        int[] arr ={4,-8,0,8};
        //int[] arr ={-6,4,-5,8,-10,0,8};
        //getSubSets(arr,6);
        //System.out.println(max);

        System.out.println(findmaxProdcutInLinear(arr,4));

    }



      public static void findMax(Stack<Integer> st){

          int prodcut=1;

          for(int i:st){
              prodcut=prodcut*i;
          }
          max= Math.max(prodcut,max);

      }




     public static void getSubSets(int arr[],int n){
         if(n<0){
        findMax(set);
             return;
         }
         set.push(arr[n]);
         getSubSets( arr, n-1);
         set.pop();
         getSubSets( arr, n-1);
     }


    public static int findmaxProdcutInLinear(int arr[],int n){

        int product=1;
        int positive=0;
        int negetive=0;
        int zero=0;
        int min_abs=Integer.MAX_VALUE;

         for(int i=0;i<n;i++){

             if(arr[i]<0){
                 negetive++;
                 min_abs= Math.min(min_abs,Math.abs(arr[i]));
             }
             if(arr[i]>0){
                 positive++;
             }

             if(arr[i]==0){
                 zero=1;
             } else {
                 product=product*arr[i];
             }

         }

        if(negetive%2==1){
            product=product/-min_abs;
        }

        if(negetive==1 && positive==0 && zero==1){
            product=0;
        }
        return product;


    }


}
