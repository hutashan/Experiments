package arr;

import java.util.HashMap;

public class MinimumSumPartition {
 static HashMap<String,Integer> lookup = new HashMap<String,Integer>();
    public static void main(String arg[]){
        int[] arr = {10,20,15,5,25};
        System.out.println(minimunSumPar(arr,4,0,0));

    }
    public static int  minimunSumPar(int [] s,int n, int s1,int s2){

        if (n<0){
            return Math.abs(s1-s2);
        }

        String key = n+""+s1;

        if (!lookup.containsKey(key)) {
            int inc = minimunSumPar(s, n - 1, s1 + s[n], s2);
            int exe = minimunSumPar(s, n - 1, s1, s2 + s[n]);
            lookup.put (key,Math.min(inc,exe));
        }
        return lookup.get(key);

    }


}
