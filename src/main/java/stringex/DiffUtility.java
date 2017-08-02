package stringex;

public class DiffUtility {
    static int [][] lookup = new int [20][25];
public static void main(String str[]){
    String x = "ABCDFGHJQZ";
    String y = "ABCDEFGIJKRXYZ";
    int m = x.length();
    int n = y.length();
    LCSLength(x.toCharArray(),y.toCharArray(),m,n);
    diff(x.toCharArray(),y.toCharArray(),m,n);
}
   public static void  LCSLength(char[] x,char[] y,int m ,int n){
       for (int i=0;i<m;i++){
           lookup[i][0]=0;
       }
       for (int i=0;i<n;i++){
           lookup[0][i]=0;
       }

       for (int i=1;i<m;i++){
           for (int j=1;j<n;j++){
               if(x[i-1] == y[j-1]) {
                   lookup[i][j] = lookup[i - 1][j - 1] + 1;
               } else {
                   lookup[i][j] = java.lang.Math.max(lookup[i][j - 1],lookup[i-1][j]);
               }


           }
       }

   }
    public static void diff(char[] x,char[] y,int m ,int n){
        if (m>0 && n>0 && x[m-1]==y[n-1]){
            diff(x,y,m-1,n-1);
            System.out.print(" " + x[m-1]);
        } else if (n>0 && (m==0 || lookup[m][n-1]>=lookup[m-1][n])){
            diff(x,y,m,n-1);
            System.out.print(" + " + y[n-1]);
        } else if (m>0 && (n==0 || lookup[m][n-1]<lookup[m-1][n])){
            diff(x,y,m-1,n);
            System.out.print(" - " + x[m-1]);
        }
    }
}

