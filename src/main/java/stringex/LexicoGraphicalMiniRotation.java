package stringex;


import java.util.Arrays;


public class LexicoGraphicalMiniRotation {
    public static void main(String a[]){
        miniRotation("GEEKSFORGEEKS");

    }
    public static void miniRotation(String s){
        String con = s +s;
        String[] arr = new String [s.length()];
        for (int i=0;i<s.length();i++){
            arr[i]=con.substring(i,s.length()+i);
        }
        Arrays.sort(arr);
        System.out.println(arr[0])
;    }
}

