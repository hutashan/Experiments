package stringex;

import java.util.*;

public class SubStringPermutation {
    public static void main(String a[]){
        String X="XYYZXZYZXXYZ";
        char[]x=X.toCharArray();
        String Y="XYZ";
        char[] y=Y.toCharArray();

        ArrayList window = new ArrayList();
        ArrayList st = new ArrayList();
        for (int i=0;i<Y.length();i++){
            st.add(y[i]);
        }
        for (int i=0;i<x.length;i++){
            if(i<y.length){
                window.add(x[i]);
            } else{
                ArrayList one = new ArrayList<String>(window);
                ArrayList two = new ArrayList<String>(st);
                Collections.sort(one);
                Collections.sort(two);
                if(one.equals(two)){
                    System.out.println(window);
                    System.out.println(i-3);
                }
                window.remove(0);
                window.add(x[i]);
            }
        }

    }

}
