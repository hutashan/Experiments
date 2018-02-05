package arr;

import java.util.Arrays;
import java.util.Stack;

public class PrintAllDistinctSubset {
    public static void main(String arg[]){
        int[] a = {1,2,3};

      //  Arrays.sort(a);

    //    powerSubset(a,new Stack(),a.length-1);
        powerSubset1(a,"",0,2,a.length-1);
    }

    public static void powerSubset1(int[] s, String res, int l, int k,int n){

        if (k==0){
            System.out.println(res);
           return;
        }

        for (int i=0;i<=n;i++){
            if (!res.equals(s[i]+"")){
                powerSubset1(s,res+s[i],i,k-1,n) ;
            }


        }
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
