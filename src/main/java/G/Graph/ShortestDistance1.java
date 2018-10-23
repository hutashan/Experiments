package G.Graph;

import java.util.LinkedList;

public class ShortestDistance1 {
    public static void main(String arg[]) {
        int[][] input = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(new ShortestDistance1().shortestDistance(input));
    }
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        final int[] shift = new int[] {0, 1, 0, -1, 0};
        int row  = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;
        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if(grid[i][j]==1){
                buildingNum++;
                    LinkedList<int[]> myQueue = new LinkedList<int[]>();
                    myQueue.offer(new int[] {i,j});
                    boolean[][] isVisited = new boolean[row][col];
                    int level = 1;
                    while (!myQueue.isEmpty()){
                        int qSize = myQueue.size();
                        for(int q=0;q<qSize;q++){
                            int[] curr = myQueue.poll();
                            for(int direction=0;direction<4;direction++){
                                int newRow = curr[0] + shift[direction];
                                int newCol = curr[1] + shift[direction+1];
                                if(newRow>=0 && newCol>=0 && newRow<row && newCol<col && !isVisited[newRow][newCol] && grid[newRow][newCol]==0
                                        ){
                                    isVisited[newRow][newCol]=true;
                                    distance[newRow][newCol] += level;
                                    reach[newRow][newCol]++;
                                    myQueue.offer(new int[] {newRow,newCol});

                                }
                            }

                        }level++;

                         }

                    }

                }
            }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }

        if(shortest == Integer.MAX_VALUE){
            return -1;
        }else
        return shortest;

    }
}
