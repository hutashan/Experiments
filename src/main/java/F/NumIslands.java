package F;

public class NumIslands {
    public static void main(String[] args) {
        char [] [] island = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(new NumIslands().numIslands(island));

    }
    public int numIslands(char[][] grid) {
        if(grid==null) return 0;
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   utilnumIslands(grid,i,j);
                    max++;
                }
            }

        }
        return max;
    }
    public void utilnumIslands(char[][] grid,int i,int j) {
        grid[i][j]=0;
        int n = grid.length;
        int m=grid[0].length;
        if(i+1<n && grid[i+1][j]==1)
           utilnumIslands(grid,i+1,j);
        if(j+1<m && grid[i][j+1]==1)
            utilnumIslands(grid,i,j+1);
        if(i-1>=0 && grid[i-1][j]==1)
            utilnumIslands(grid,i-1,j);
        if(j-1>=0 && grid[i][j-1]==1)
            utilnumIslands(grid,i,j-1);

    }

}
