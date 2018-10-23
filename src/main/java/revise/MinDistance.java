package revise;

public class MinDistance {
    public static void main(String[] args) {
        String word1="horse";
        String word2="ros";
        System.out.println(new MinDistance().minDistance(word1,word2));
    }

    public int minDistance(String word1, String word2) {

        int row = word1.length();
        int col=word2.length();
        int [] [] lookup = new int [row+1][col+1];
        lookup[0][0]=0;
        for(int i=1;i<=row;i++){
            lookup[i][0]=lookup[i-1][0]+1;
        }
        for(int i=1;i<=col;i++){
            lookup[0][i]=lookup[0][i-1]+1;
        }
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    lookup[i][j]=lookup[i-1][j-1];
                } else{
                    lookup[i][j]=Math.min(Math.min(lookup[i-1][j],lookup[i][j-1]),lookup[i-1][j-1])+1;
                }

            }
        }
        return lookup[row][col];
    }
}
