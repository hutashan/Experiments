package stringex;


public class WildcardPatternMatching {

    public static void main(String a[]){
        String pattern = "x*y";
        String str = "xxyyxy";
        System.out.println(isMatching(str.toCharArray(),pattern.toCharArray()));


    }


    public static boolean isMatching(char[] str,char[] pattern){
        int n = str.length;
        int m = pattern.length;
        boolean[][] lookup = new boolean [n+1][m+1];
        lookup[0][0]=true;

        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (i==0 && pattern[j-1]=='*'){
                    lookup[i][j]=lookup[i][j-1];
                }else if (pattern[j-1] == '*'){
                    lookup[i][j]=lookup[i][j-1]|| lookup[i-1][j];
                } else if (pattern[j-1]=='?' || str[i-1]==pattern[j-1]){
                    lookup[i][j]=lookup[i-1][j-1];
                }
            }
        }
        return lookup[n][m];
    }








}
