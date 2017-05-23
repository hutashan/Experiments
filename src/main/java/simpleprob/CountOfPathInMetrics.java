package simpleprob;

/**
 * Created by parmana on 5/11/17.
 */
public class CountOfPathInMetrics {


     static int size =8;
    static  int maze[][] = {    {1, 1, 1, 1,1,1,1,1},
                                {1, 1, 0, 1,1,1,0,1},
                                {1, 1, 1, 1,0,1,1,1},
                                {0, 1, 0, 1,1,0,1,1},
                                {1, 1, 0, 1,1,1,1,1},
                                {1, 1, 1, 0,0,1,0,1},
                                {1, 0, 1, 1,1,0,1,1},
                                {1, 1, 1, 1,1,1,1,1}
    };

    public static int countpath(int[][] a,int row,int col){

        if(row==size||col==size)
            return 0;

        if(isEnd(col,row)){
            return 1;
        }
        if(!isValidpath(a,col,row)){
            return 0;
        }


        return countpath(a,row+1,col)+countpath(a,row,col+1);

    }

    public static boolean isValidpath(int[][] a,int col,int row){
       /* System.out.println("row " +row+ " col "+col);
        if(row==size||col==size)
            return false;*/
        if(a[row][col]==0){
            return false;
        } else {
            return true;
        }
    }

    public static boolean isEnd(int col,int row){
        if(col==size-1 && row==size-1){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int a= countpath(maze,0,0);
        System.out.println("a---"+a);


    }

}
