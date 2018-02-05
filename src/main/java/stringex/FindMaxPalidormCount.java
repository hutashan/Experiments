package stringex;


import datastructure.In;

import java.util.HashMap;

public class FindMaxPalidormCount {
    static int[][] lookup ;

    public static void main(String a[]){
        String s = "abaab";
      //  System.out.printf( countPalirom("xabak",0,4)+"");
       // System.out.printf( countPaliromMemo(s,0,s.length()-1,new HashMap<String, Integer>())+"");
         //printPalidromUsingMemo(s);
       // System.out.println(lps(s));
      //  printLongestPalirom(s);
       countAllPalirom  (s);

    }

    // count all palirdrome
    public static void countAllPalirom(String s){
        int n = s.length();
        boolean[][] lt = new boolean[n][n];
        lookup = new int[n][n];
        int maxLen =1;
        for (int i=0;i<n;i++){
            lt[i][i]=true;
        }
        int start =0;
        for (int i=0;i<n-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                lt[i][i+1]=true;
               lookup[i][i+1]=1;
            }

        }
        for (int g =2;g<n;g++) {
            for (int i = 0; i < n-g; i++) {
                int j = g+i;
                if (lt[i+1][j-1]&& s.charAt(i)==s.charAt(j)){
                    lt[i][j]=true;
                    lookup[i][j]=lookup[i+1][j]+lookup[i][j-1]+1-lookup[i+1][j-1];
                } else{
                    lookup[i][j]=lookup[i+1][j]+lookup[i][j-1]-lookup[i+1][j-1];
                }
            }
        }
        System.out.println(lookup[0][n-1]);

    }







    public static void printLongestPalirom(String s){
        int n = s.length();
        boolean[][] lt = new boolean[n][n];
        int maxLen =1;
        for (int i=0;i<n;i++){
            lt[i][i]=true;
        }
        int start =0;
        for (int i=0;i<n-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                lt[i][i+1]=true;
                start=1;
                maxLen=2;
            }

        }
        for (int g =3;g<n;g++) {
            for (int i = 0; i < n-g+1; i++) {
               int j = g+i-1;
                if (lt[i+1][j-1]&& s.charAt(i)==s.charAt(j)){
                    lt[i][j]=true;
                    if(g>maxLen){
                        start=i;
                        maxLen=g;
                    }
                }
            }
        }
        System.out.println(s.substring(start,start+maxLen));

    }






  static int lps(String s){
        int n = s.length();
        int [][] lookup = new int [n][n];
        for (int i=0;i<n;i++){
            lookup[i][i]=1;
        }
        for(int gap=2;gap<=n;gap++){
            for (int i=0;i<n-gap+1;i++){
                int j = i+gap-1;
                if (s.charAt(i)==s.charAt(j) && gap==2){
                    lookup[i][j]=2;
                }else if(s.charAt(i)==s.charAt(j)){
                    lookup[i][j]=lookup[i+1][j-1]+2;
                } else{
                    lookup[i][j]=Math.max(lookup[i][j-1],lookup[i+1][j]);
                }
            }
        }
        return lookup[0][n-1];
  }












    static public void printPalidromUsingMemo(String s){
        getLookUp(s);
        String s1 = new StringBuffer(s).reverse().toString();
        // printPali(s,s1,s1.length()-1,s1.length()-1);
        System.out.println( printPali(s,s1,s1.length()-1,s1.length()-1));
    }


  // create  lookup 2d for memorization
  static public int[][] getLookUp(String s){
      String s1 = new StringBuffer(s).reverse().toString();
      int n = s.length();
      lookup = new int[n+1][n+1];
      // lookup building
      for (int i =1;i<=n;i++ ){
          for (int j=1;j<=n;j++){
              if (s.charAt(i-1)==s1.charAt(j-1)){
                  lookup[i][j]=lookup[i-1][j-1]+1;
              } else {
                  lookup[i][j]=Math.max(lookup[i-1][j],lookup[i][j-1]);
              }
          }
      }
      return lookup;
  }








    static public String printPali(String s,String s1,int i,int j){
     if (i==0|| j ==0){
         return new String("");
     }
      if (s.charAt(i)==s1.charAt(j)){
            return printPali(s,s1,i+1,j-1)+s.charAt(i);
      }
        if(lookup[i-1][j]>lookup[i][j-1]){
            return printPali(s,s1,i-1,j);
        }
         return printPali(s,s1,i,j-1);
    }

    static   public int countPaliromMemo(String st, int start, int end, HashMap  <String, Integer> hs) {
        if (st == null) {
            return 0;
        }

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }
        String key = start + "|" + end;
        if (!hs.containsKey(key)) {
            if (st.charAt(start) == st.charAt(end)) {
                hs.put(key, countPalirom(st, start + 1, end - 1) + 2);
            } else {
                hs.put(key, Math.max(countPalirom(st, start + 1, end), countPalirom(st, start, end - 1)));
            }

        }
        return hs.get(key);
    }
     static   public int countPalirom(String st, int start, int end){
        if (st==null){
            return 0;
        }

      if (start>end) {
          return 0;
      }

      if (start==end){
          return 1;
      }
            if (st.charAt(start) == st.charAt(end)) {
                return countPalirom(st, start + 1, end - 1) + 2;
            } else {
                return Math.max(countPalirom(st, start + 1, end), countPalirom(st, start, end - 1));
            }
    }

}
