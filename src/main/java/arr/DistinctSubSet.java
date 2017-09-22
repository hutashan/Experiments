package arr;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by parmana on 8/11/17.
 */
public class DistinctSubSet {

   static Stack<Integer> st = new Stack<Integer>();
    public static void main(String[] args) {

        int[] arr ={1,2,3};
        Arrays.sort(arr);
        findSet(arr,st,arr.length-1);


    }

    public  static void print(){
       for(int i:st){
           System.out.print(i + " ");
       }

    }

    public static void findSet(int[] arr,Stack<Integer> st,int i){


        if(i<0){
            print();
            System.out.println();
            return;
        }

        st.push(arr[i]);
        findSet(arr,st,i-1);
        st.pop();
        System.out.println("before while "+i);
        while ( i>=1 && arr[i]==arr[i-1]){
            i--;
        }
        findSet(arr,st,i-1);

    }



}
