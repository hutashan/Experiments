package w;

public class DistanceMatrix {
    public static void main(String[] args) {
        int row=3,col=3;
        int startRow=1,startCol=1;
        int endRow=3,endCol=2;
        int blockerRow1 =2,blockerCol1=1;
        int blockerRow2 =2,blockerCol2=2;
        int [][] matrix = new int [row][col];

        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                matrix[i][j]=Integer.MAX_VALUE;
            }
        }
        matrix[blockerRow1-1][blockerCol1-1]=-1;
        matrix[blockerRow2-1][blockerCol2-1]=-1;
        boolean [][] visted = new boolean[row][col];
        new DistanceMatrix().getDistance(matrix,startRow-1,startCol-1,endRow-1,endCol-1,matrix.length,matrix[0].length,0,visted);
        System.out.println(matrix[endRow-1][endCol-1]-1);

    }
    public void getDistance (int [][] matrix,int startRow,int startCol,int endRow,int endcol,int rowLen,int colLen,int curVal,boolean[][] visited){
        matrix[startRow][startCol]=Math.min(curVal+1,matrix[startRow][startCol]);
        visited[startRow][startCol]=true;
        if(startRow==endRow && startCol== endcol) return;
         if(startRow+1<rowLen && matrix[startRow+1][startCol]!=-1 && (!visited[startRow+1][startCol])){
             getDistance(matrix,startRow+1,startCol,endRow,endcol,rowLen,colLen,matrix[startRow][startCol],visited)  ;
         }
        if(startCol+1<colLen && matrix[startRow][startCol+1]!=-1 && (!visited[startRow][startCol+1])){
            getDistance(matrix,startRow,startCol+1,endRow,endcol,rowLen,colLen,matrix[startRow][startCol],visited)  ;
        }
        if((startCol-1)>=0 && matrix[startRow][startCol-1]!=-1 && (!visited[startRow][startCol-1])){
            getDistance(matrix,startRow,startCol-1,endRow,endcol,rowLen,colLen,matrix[startRow][startCol],visited)  ;
        }
        if((startRow-1)>=0 && matrix[startRow-1][startCol]!=-1 && (!visited[startRow-1][startCol])){
            getDistance(matrix,startRow-1,startCol,endRow,endcol,rowLen,colLen,matrix[startRow][startCol],visited)  ;
        }

    }

}
