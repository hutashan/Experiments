package TopQ;

public class Rotate {
    public static void main(String[] args) {
        int [][] ma = {{1,2,3},{4,5,6},{7,8,9}};
        new Rotate().rotate(ma);

    }
    public void rotate(int[][] matrix) {
        if(matrix==null) return;
        matrix = reverseMatix(matrix);
        int rows = matrix.length;
        int cols=matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = row; col < cols; col++) {
                matrix= swapVal(matrix,row,col);
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }

    }
    private int[][] swapVal(int[][] matrix,int row1,int col1){
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[col1][row1];
        matrix[col1][row1]=temp;
        return matrix;
    }
    private int[][] reverseMatix(int[][] matrix ){
        int rows = matrix.length;
        int cols=matrix[0].length;

        for (int row = 0; row < rows / 2; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[rows - 1 - row][col];
                matrix[rows - 1 - row][col] = temp;
            }
        }
        return matrix;
    }
}
