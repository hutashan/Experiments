package arr;

import java.util.HashMap;

/**
 * Created by parmana on 9/9/17.
 */
public class FindFrequncy {

    static HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();

    public static void main(String[] args) {

        int[] arr ={2,2,3,3,5};
        freq(arr,4,0);
        System.out.printf(map.toString());
    }


    public static void freq(int[] arr,int n,int st){

        if(arr[st]==arr[n]){
            if(map.containsKey(arr[st])){
              int a=  map.get(arr[st]);
                map.put(arr[st],a+n);
            } else {
                map.put(arr[st],n);
            }
            return;
        }

        freq(arr,n/2,st=0);
        System.out.println("df");
        freq(arr,n,(n/2)+1);
        System.out.println("d");

    }



}
