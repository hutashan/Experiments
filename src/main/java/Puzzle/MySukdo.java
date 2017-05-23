package Puzzle;

import java.util.List;

/**
 * Created by parmana on 5/22/17.
 */
public class MySukdo {

    static int[][] baord =
                   {{5, 0, 4, 6, 7, 8, 0, 0, 2},
                    {6, 0, 2, 1, 9, 5, 3, 4, 8},
                    {1, 0, 8, 3, 4, 2, 5, 6, 7},
                    {8, 5, 9, 7, 6, 1, 4, 2, 3},
                    {4, 0, 6, 8, 0, 3, 7, 9, 1},
                    {7, 1, 3, 9, 2, 4, 8, 5, 6},
                    {9, 6, 1, 5, 3, 7, 2, 8, 4},
                    {2, 0, 7, 4, 1, 9, 6, 3, 5},
                    {3, 4, 5, 2, 8, 6, 1, 7, 9}};

    public static void main(String[] args) {

        for(int i =0;i<baord[0].length;i++){
            for(int j=0;j<baord.length;j++){
                if(baord[i][j]==0){
                 List<Integer> l=  getPosibleValue(i,j);
                 for(int p:l){
                     System.out.print(p);
                 }
                }
            }
        }

    }

    public static boolean isFull(){
        for(int i =0;i<baord[0].length;i++){
            for(int j=0;j<baord.length;j++){
                if(baord[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }



    public static List<Integer> getPosibleValue(int row,int col){
      int p[] ={0,0,0,0,0,0,0,0,0,0};
      List l = new java.util.ArrayList<Integer>();

        for(int i=0;i<10;i++){

        }

      return l;
    }
}
