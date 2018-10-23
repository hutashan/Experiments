package F;

public class SparseMatrixMultiplication {
    public static void main(String[] args) {
    int [][] A ={{1, 0, 0},
                {-1, 0, 3}};
    int [][] b = {{7, 0, 0},
                  {0, 0, 0},
                   {0,0,1}};
    int [][] result = new SparseMatrixMultiplication().multiply(A,b);
    for(int [] a : result){
        for(int v :a){
            System.out.print(v +" , ");
        }
        System.out.println();
    }

    }
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int [][] result = new int [m][nB];
        for(int Arow=0;Arow<m;Arow++){
            for(int ACol=0;ACol<n;ACol++){
                if( A[Arow][ACol] != 0) {
                    for(int Bcol=0;Bcol<nB;Bcol++) {
                        if(B[ACol][Bcol]!=0)

                            result[Arow][Bcol] =+ (A[Arow][ACol] * B[ACol][Bcol]);
                    }
                }

            }

        }
        return result;
    }

}
