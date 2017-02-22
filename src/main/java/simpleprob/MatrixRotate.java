package simpleprob;

public class MatrixRotate {

    public static void main (String arg[]){
       int matrixSize =4;
        int [][]matrix = new int [matrixSize][matrixSize];
        int counter=0;
        for (int i=0; i<matrixSize;i++ ){
            for (int j=0;j<matrixSize;j++){
                matrix[i][j]=counter++;
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("new Matix");
        int [][]matrix_new  =rotate(matrix,matrixSize);

        for (int i=0; i<matrixSize;i++ ){
            for (int j=0;j<matrixSize;j++){
                System.out.print(matrix_new[i][j] + "  ");
            }
            System.out.println("");
        }

    }

    public static int [][] rotate(int [][] matrix,int matrixSize){
       int level = findLevel(matrixSize);

        int scanningLevel =0;
        int last = matrixSize-1;
        while (scanningLevel<level){
            System.out.println("level " + scanningLevel);
            for (int i=scanningLevel;i<last;i++){

                swap(matrix, scanningLevel,i, i,last);
                swap(matrix,scanningLevel,i,last,last-i+scanningLevel);
                swap(matrix,scanningLevel,i,last-i+scanningLevel,scanningLevel);
            }
            scanningLevel++;
            last--;
        }
        return matrix;
    }
    public static int [][] swap(int [][] matrix,int i0,int j0,int i1,int j1){

        int temp = matrix[i0][j0];
        matrix[i0][j0] = matrix[i1][j1];
        matrix[i1][j1] = temp;
        return matrix;
    }

    public static int findLevel (int matrixSize){
        int level = matrixSize/2;
        return level;
    }

}
