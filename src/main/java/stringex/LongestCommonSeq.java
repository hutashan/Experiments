package stringex;


import java.util.HashMap;

public class LongestCommonSeq {
    public static void main(String a[]){

        String X = "ABCBDAB", Y = "BDCABA";
        System.out.println("LCS " + LCSLength(X.toCharArray(),Y.toCharArray(),X.length(),Y.length()));
        HashMap<String,Integer> hs = new HashMap<String,Integer>();
        System.out.println("LCS mem" + LCSLengthMemorozation(X.toCharArray(),Y.toCharArray(),X.length(),Y.length(),hs));
        int[][] lookup  = new int[X.length()+1][Y.length()+1];
        System.out.println("LCS memloop" + LCSLenMemButtomUPLoop(X.toCharArray(),Y.toCharArray(),lookup));
        System.out.println("LCS  is " + LCS(X.toCharArray(),Y.toCharArray(),X.length(),Y.length(),lookup));

    }


    static int LCSLength(char[] x,char[] y,int i,int j){
        if (i==0||j==0){
            return 0;
        }
        if(x[i-1]==y[j-1]){
            return LCSLength(x,y,i-1,j-1) +1;
        } else{
            return Math.max(LCSLength(x,y,i-1,j),LCSLength(x,y,i,j-1));
        }

    }


    static int LCSLengthMemorozation(char[] x, char[] y, int i, int j, HashMap<String,Integer> hs){
        if (i==0||j==0){
            return 0;
        }
        String key = i+""+j;
        if (!hs.containsKey(key)) {
            if (x[i - 1] == y[j - 1]) {
                hs.put(key,LCSLengthMemorozation(x, y, i - 1, j - 1,hs) + 1);
            } else {
                hs.put(key, Math.max(LCSLengthMemorozation(x, y, i - 1, j,hs), LCSLengthMemorozation(x, y, i, j - 1,hs)));
            }
        }
        return hs.get(key);

    }


    static int LCSLenMemButtomUPLoop(char[] x, char[] y,int[][] lookup ){
     int m = x.length ,n=y.length;
        for (int i=0;i<=m;i++){
            lookup[i][0]=0;
        }
        for (int j=0;j<=n;j++){
            lookup[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x[i-1]==y[j-1]){
                    lookup[i][j]=lookup[i-1][j-1]+1;
                }else{
                    lookup[i][j]=Math.max(lookup[i-1][j],lookup[i][j-1]);
                }
            }

        }
        return lookup[m][n];
    }

    static String LCS (char[] x, char[] y,int m,int n ,int [][] lookup){
      if(m==0||n==0){
          return "";
      }
        if (x[m-1]==y[n-1]){
            return LCS(x,y,m-1,n-1,lookup)+x[m-1];
        }
        if (lookup[m-1][n]>lookup[m][n-1]){
            return LCS(x,y,m-1,n,lookup);
        }else{
            return  LCS(x,y,m,n-1,lookup);
        }

    }







}
