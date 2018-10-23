package G;

public class MinimumPathSum {
    public static void main(String[] args) {
        int [][] Input1 ={
                {1,3,1},
                {1,5,1},
                {4,2,1}

        };


        int [][] Input ={
                {1,2,5},
                {3,2,1}

        };
        System.out.println(new MinimumPathSum().minPathSum(Input));
    }
    public int minPathSum(int[][] grid) {
        int row =grid.length;
        int col = grid[0].length;
        int [][] lookup = new int[grid.length][grid[0].length];

        return minPath1(grid,0,0,lookup,row,col);


    }
    public int minPath1(int[][] grid,int i,int j,int [][] lookup,int row,int col) {
       if (i==row-1 && j ==col-1)
           return grid[i][j];
        int v1=Integer.MAX_VALUE,v2 =Integer.MAX_VALUE;
       if(i+1<row && j<col){
            v1 =minPath(grid,i+1,j,lookup,row,col);

       }
        if(j+1<col && i<row){
             v2= minPath(grid,i,j+1,lookup,row,col);

        }

        return grid[i][j]+Math.min(v1,v2);

    }




    public int minPath(int[][] grid,int i,int j,int [][] lookup,int row,int col) {
        if (i==row-1 && j ==col-1)
            return grid[i][j];
        int v1=Integer.MAX_VALUE,v2 =Integer.MAX_VALUE;
        if(i+1<row && j<col){
            v1=lookup[i+1][j];
            if(v1==0)
            v1 =minPath(grid,i+1,j,lookup,row,col);

        }
        if(j+1<col && i<row){
            v2=lookup[i][j+1];
            if(v2==0)
            v2= minPath(grid,i,j+1,lookup,row,col);

        }

        lookup[i][j]=grid[i][j]+Math.min(v1,v2);

        return lookup[i][j] ;

    }

}

