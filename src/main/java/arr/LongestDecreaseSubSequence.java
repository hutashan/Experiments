package arr;

import java.util.List;

/**
 * Created by parmana on 9/9/17.
 */
public class LongestDecreaseSubSequence {

    public static void main(String[] args) {
        int[] arr={0,8,4,12,10,2};
       // System.out.println(lds(arr,0,6,Integer.MAX_VALUE));
        //ldsByDp(arr);
        lIsByDp(arr);

    }


    public static int lds(int[] arr, int i,int n,int prev){

        if(i==n){
            return 0;
        }

        int excl=lds(arr,i+1,n,prev);

        int inclu=0;
        if(arr[i]<prev)
            inclu=1+lds(arr,i+1,n,arr[i]);

        return Math.max(excl,inclu);

    }


    public static int ldsByDp(int[] arr){
        int max=1;

        int t[]=new int[arr.length];
        t[0]=1;

      for(int i=1;i<arr.length;i++){
           for(int j=0;j<i;j++){

               if(arr[i]>arr[j]){
                   t[i]=Math.max(t[j]+1,t[i]);
               }
           }
      }

       for(int i:t){
           System.out.println(i);
       }


        return 1;
    }


    public static int lIsByDp(int[] arr){
        int max=1;
        List<List<Integer>> l= new java.util.ArrayList<List<Integer>>();

        int t[]=new int[arr.length];
        t[0]=1;

        for(int i=1;i<arr.length;i++){
            List l1=   new java.util.ArrayList<Integer>();
            for(int j=0;j<i;j++){

                if(arr[i]<arr[j]){
                    t[i]=Math.max(t[j]+1,t[i]);
                    l1.add(arr[j]);
                }
            }
            l.add(l1);
        }

        List temp = new java.util.ArrayList<Integer>();
        for(List l2:l){
            if(l2.size()>temp.size()){
                temp=l2;
            }
        }
        System.out.println(temp);

        for(int i:t){
            System.out.println(i);
        }




        return 1;
    }

}
