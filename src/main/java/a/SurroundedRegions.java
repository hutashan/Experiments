package a;

import java.util.ArrayList;
import java.util.HashMap;

public class SurroundedRegions {
    public static void main(String[] args) {
        char [][] board ={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new SurroundedRegions().solve(board);
        String [] w = {"wrs"};
        int min=Integer.MAX_VALUE;
        HashMap<String, ArrayList<Integer>> map = null;
        map.get("y").add(1);


    }
    public void solve(char[][] board) {
        if (board==null || board.length==0) return;
        int n = board.length;
        int m = board[0].length;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(board[i][j]=='O'){
                    char c = board[i][j];
                    if((i-1==0 && board[i-1][j]=='O')) {
                        continue;
                    }
                    if((i+1==n && board[i+1][j]=='O')) {
                        continue;
                    }
                    if((j-1==0 && board[i][j-1]=='O')) {
                        continue;
                    }
                    if((j+1==m && board[i][j+1]=='O')) {
                        continue;
                    }
                    board[i][j]='X';
                }
            }
        }
        for( char[] b : board){
            for(char b1 : b)  {
                System.out.print(b1);
            }
            System.out.println();
        }
    }

}
