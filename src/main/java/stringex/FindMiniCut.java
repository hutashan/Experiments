package stringex;


import scala.reflect.internal.Trees;

public class FindMiniCut {

    static int [][] lookup =  new int [3][3];
    static char[] c = "BAB".toCharArray();

    public static void main(String a []){

        miniumCut(c,c.length);
        minPali(c.length);
    }

    public static void minPali( int n){
        int t[] = new int[3];
        for (int i =n-1;i>=0;i--){
            t[i]=Integer.MAX_VALUE;
            if(lookup[i][n-1]==1){
                t[i]=0;
            } else{
                for (int j=n-2;j>=i;j--){
                    if(lookup[i][j]==1){
                        t[i]= Math.min(t[i],1+t[j+1]);
                    }
                }
            }
        }
        System.out.printf("Finally print" +t[0] );
    }





    static  public void miniumCut(char[] str, int n) {
    for (int i=n-1;i>=0;i--){
        for (int j=i;j<n;j++){
            if (i==j){
                lookup[i][j] = 1;

            } else if (str[i] ==str[j]) {

                lookup[i][j]= (j-i==1)?1:lookup[i+1][j-1];
            } else {
                lookup[i][j]=0;
            }

        }
    }

    }


}
