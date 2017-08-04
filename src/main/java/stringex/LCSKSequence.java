package stringex;


import java.util.HashMap;

public class LCSKSequence {
    public static void main(String a[]){
        String X = "ABCBDAB", Y = "BDCABA", Z = "BADACB";

        System.out.println(LCSLength(X.toCharArray(),Y.toCharArray(),Z.toCharArray(),X.length(),Y.length(),Z.length()));

        HashMap<String ,Integer> hs = new HashMap<String,Integer>();

        System.out.println("mem "+LCSLengthMemorize(X.toCharArray(),Y.toCharArray(),Z.toCharArray(),X.length(),Y.length(),Z.length(),hs));


    }

    static int LCSLength(char[] X,char[] Y,char[] Z,int i,int j,int k){
        if(i==0 || j==0 || k==0){
            return 0;
        }
        if(X[i-1]==Y[j-1] && Y[j-1]==Z[k-1]){
           return LCSLength(X,Y,Z,i-1,j-1,k-1) +1;
        } else{
          return Math.max(Math.max(LCSLength(X,Y,Z,i-1,j,k),LCSLength(X,Y,Z,i,j-1,k)),LCSLength(X,Y,Z,i,j,k-1));
        }

    }

    static int LCSLengthMemorize(char[] X,char[] Y,char[] Z,int i,int j,int k,HashMap<String,Integer> hs){
        if(i==0 || j==0 || k==0){
            return 0;
        }
        String key = i+"|"+j+"|"+k;
        if (!hs.containsKey(key)) {

            if (X[i - 1] == Y[j - 1] && Y[j - 1] == Z[k - 1]) {
                hs.put(key, (LCSLengthMemorize(X, Y, Z, i - 1, j - 1, k - 1,hs) )+ 1);
            } else {
                hs.put(key,Math.max(Math.max(LCSLengthMemorize(X, Y, Z, i - 1, j, k,hs), LCSLengthMemorize(X, Y, Z, i, j - 1, k,hs)), LCSLengthMemorize(X, Y, Z, i, j, k - 1,hs)));
            }
        }
            return (hs.get(key));


    }





}
