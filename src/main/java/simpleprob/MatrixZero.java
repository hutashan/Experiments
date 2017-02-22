package simpleprob;

public class MatrixZero {
public static void main (String a[]){
    int zeroRow =1;
    int zeroCol =1;
    int matrixSize =4;
    int [][]matrix = new int [matrixSize][matrixSize];
    int counter=0;
    for (int i=0; i<matrixSize;i++ ){
        for (int j=0;j<matrixSize;j++){
            if (i ==zeroRow && j==zeroCol) {
                matrix[i][j] = 0;
            } else {
                matrix[i][j] = counter++;
            }
                System.out.print(matrix[i][j] + "  ");
        }
        System.out.println("");
    }
    boolean [] row = new boolean[matrixSize];
    boolean [] col = new boolean[matrixSize];

    for (int i=0; i<matrixSize;i++ ) {
        for (int j = 0; j < matrixSize; j++) {
            if (matrix[i][j] == 0){
                row[i] = true;
                col[j] = true;
            }
        }
    }
    for (int i=0; i<matrixSize;i++ ) {
        for (int j = 0; j < matrixSize; j++) {
            if (row[i] || col[j]) {
                matrix[i][j]=0;
            } else {

            }
        }
    }

    System.out.println("new array");

    for (int i=0; i<matrixSize;i++ ){
        for (int j=0;j<matrixSize;j++){
            System.out.print(matrix[i][j] + "  ");
        }
        System.out.println("");
    }




}

}
