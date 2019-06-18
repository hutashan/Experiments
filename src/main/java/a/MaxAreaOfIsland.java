package a;

public class MaxAreaOfIsland {
    int gobal,max=0;
    public static void main(String[] args) {
        int [][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));

    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid[0].length==0) return 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max=0;
                    dfs(grid,i,j);
                    gobal=Math.max(gobal,max) ;
                }
            }
        }
        return gobal;
    }

    private void dfs(int [][] grid ,int i,int j){
        grid[i][j]=0;
        max++;
        if(i-1>=0 &&  grid[i-1][j] ==1) dfs(grid,i-1,j);
        if(j-1>=0 &&  grid[i][j-1] ==1) dfs(grid,i,j-1);
        if(i+1<grid.length &&  grid[i+1][j] ==1) dfs(grid,i+1,j);
        if(j+1<grid[0].length &&  grid[i][j+1] ==1) dfs(grid,i,j+1);
    }

}
