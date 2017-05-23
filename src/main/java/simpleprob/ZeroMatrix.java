package simpleprob;

/**
 * Created by parmana on 2/20/17.
 */
public class ZeroMatrix {

    static int matrix_size= 4;
  static int counter=0;
    public static void main(String[] args) {
       int mat[][]= new int[matrix_size][matrix_size];
       for(int i = 0;i<matrix_size;i++){

             for (int j=0;j<matrix_size;j++){
                 mat[i][j]=counter;
                 counter++;
             }

        }


        for(int i = 0;i<matrix_size;i++){

            for (int j=0;j<matrix_size;j++){
                System.out.print(mat[i][j] + " ");

            }
            System.out.println();
        }


        System.out.println("------------");

        setZero(mat);

    }


    public  static void setZero(int[][] m ){
      boolean[] row= new boolean[m.length];
        boolean[] col= new boolean[m[0].length];

        for(int i = 0;i<matrix_size;i++){

            for (int j=0;j<matrix_size;j++){
                if(m[i][j] == 0){
                    row[i]=true;
                    col[j]=true;
                }

            }

        }

        for (int i=0;i<row.length;i++){
            if(row[i]){
                nullifyRow(i, m);
            }
        }
        for (int i=0;i<col.length;i++){
            if(col[i]){
                nullifyCol(i,m);
            }
        }

        for(int i = 0;i<matrix_size;i++){

            for (int j=0;j<matrix_size;j++){
                System.out.print(m[i][j] + " ");

            }
            System.out.println();
        }
    }

   public static void nullifyRow(int row,int[][] m){
    for(int i=0;i<m[0].length;i++){
       m[row][i]=0;
    }

   }

    public static void nullifyCol(int col,int[][] m){
        for(int i=0;i<m.length;i++){
            m[i][col]=0;
        }

    }
}
