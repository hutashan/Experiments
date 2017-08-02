package Puzzle;


import java.util.ArrayList;
import java.util.List;

public class Sukdo {

    boolean isFull(int[][] board){

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

 public ArrayList<Integer> findElements(int [][] board, int r, int c) {
     System.out.println("finding element for row " +r +" col "+c);
     int[] p = {0, 0, 0, 0, 0, 0, 0, 0, 0,0 };

     for (int i = 0; i <=8; i++) {
         if (board[r][i] != 0) {
             p[board[r][i]] = 1;
         }
     }

     for (int i = 0; i <= 8; i++) {
         if (board[i][c] != 0) {
             p[board[i][c]] = 1;
         }
     }
     int ki=0;
     int kj=0;
     if (r>=0 && r<=2 ){
         kj =0;
     } else if(r>2 && r<=5){
         kj =3;
     } else {
         kj = 6;
     }

     if (c>=0 && c<=2 ){
         ki =0;
     } else if(c>2 && c<=5){
         ki =3;
     } else {
         ki = 6;
     }

     for (int m=kj;m<kj+3;m++){
        for (int n=ki;n<ki+3;n++){
        if (board[m][n] != 0) {
                p[board[m][n]] = 1;
            }
        }
     }

     ArrayList<Integer> possibleVal= new ArrayList<Integer>();
     for (int z=0;z<10;z++){
         int l=0;
         if (p[z]==0){
             possibleVal.add(z);
             l++;
         }
     }

     return possibleVal;
 }

public static void main (String [] a){
     int[][] baord =
                   {{5, 0, 4, 6, 7, 8, 0, 0, 2},
                    {6, 0, 2, 1, 9, 5, 3, 4, 8},
                    {1, 0, 8, 3, 4, 2, 5, 0, 7},
                    {8, 0, 9, 7, 0, 1, 4, 2, 3},
                    {4, 0, 6, 8, 0, 3, 7, 9, 1},
                    {7, 1, 3, 9, 2, 4, 0, 5, 6},
                    {9, 6, 1, 5, 3, 7, 2, 8, 4},
                    {2, 0, 0, 4, 0, 9, 6, 3, 0},
                    {3, 4, 5, 0, 8, 6, 1, 7, 9}};

    Sukdo s = new Sukdo();
    s.printBoard(baord);
    //System.out.println("is board full " + s.isFull(baord) );
    s.fillBoard(baord);
   // System.out.println(" " + s.isFull(baord) );
}
   public Boolean fillBoard(int[][] board){


       if (isFull(board)){
           System.out.println("Board is full");
           printBoard(board);
           return true;
       } else {
           int i=0;
           int j=0;

        /*   for (i=0;i<=8;i++){
               for( j=0;j<=8;j++){
                   if (board[i][j]==0){
                       break;
                   }

               }
               break;
           }*/
           ArrayList<Integer> arr= findCordinate(board);
            i = arr.get(0);
             j = arr.get(1);
           ArrayList<Integer> plist =findElements(board,i,j);
           System.out.println("Found possible elements "+plist);
            for (int k=0;k<plist.size();k++){
                if (plist.get(k)!=0) {
                    System.out.println("Trying  "+plist.get(k));
                    board[i][j] = plist.get(k);
                    fillBoard(board);
                }
            }
           if (plist.size()==0) {
               board[i][j] = 0;
           }
       }
       return true;
   }

    public ArrayList<Integer> findCordinate(int [][] board){
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int i=0;
        int j=0;
       while(i<=8){
            while(j<=8){
                if (board[i][j]==0){
                    ar.add(i);
                    ar.add(j);
                   return ar;
                }
                j++;
            }
           j=0;
           i++;

        }
        return null;
    }

    public void printBoard(int [][] board){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println(" ");
        }
    }


}
