package simpleprob;

/**
 * Created by parmana on 3/16/17.
 */
public class RatMazeProblem {

    int path =4;
    int maze[][] = {{1, 1, 0, 0},
                    {0, 1, 1, 1},
                    {0, 0, 0, 1},
                    {1, 1, 1, 1}
    };
    int sol[][] = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };


    public boolean isSafe(int[][] maze,int row,int col){

        if(col>=0 && col<path && row>=0 && row<path && maze[row][col]==1)
            return true;

        return false;
    }
    public boolean mazesol(int[][] maze,int row,int col,int[][] sol){

        if(col==path-1 && row==path-1){
            sol[row][col]=1;
            return true;
        }

        if(isSafe(maze,row,col)==true){

            sol[row][col]=1;

            if(mazesol(maze,row+1,col,sol))
                return true;
            if(mazesol(maze,row,col+1,sol))
                return true;
            sol[row][col] = 0;
            return false;

        }



        return false;
    }

    public void maze(){
        mazesol(maze,0,0,sol);
        System.out.println("Hello");
        printSolution();
    }
    void printSolution()
    {
        for (int i = 0; i < path; i++)
        {
            for (int j = 0; j < path; j++)
                System.out.print(" " + sol[i][j] +
                        " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new RatMazeProblem().maze();
    }


}
