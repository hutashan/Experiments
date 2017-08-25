package arr;

import java.util.Arrays;
import java.util.Stack;

public class PrintAllDistinctSubset {
    public static void main(String arg[]){
        int[] a = {1,3,1};
        Arrays.sort(a);

        powerSubset(a,new Stack(),a.length-1);

    }
    public static void powerSubset(int[] s, Stack res, int l){
        if(l<0){
            System.out.println(res.toString());
            return;
        }
        res.push(s[l]);
        powerSubset(s,res,l-1);
        res.pop();
        while(l>0 && s[l]==s[l-1]){
            l--;
        }
        powerSubset(s,res,l-1);

    }

}
