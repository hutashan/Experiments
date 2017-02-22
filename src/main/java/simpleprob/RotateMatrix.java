package simpleprob;


public class RotateMatrix {
    static String str;

    public static void main(String[] args) {
         int counter=0;
        int matrix_size=4;
        int m[][] = new int[matrix_size][matrix_size];
        str="";
        for(int i=0;i<matrix_size;i++){

            for (int j=0;j<matrix_size;j++){
                m[i][j]=counter;
                counter++;
            }

        }
        System.out.println("Original array");
        for(int i=0;i<matrix_size;i++){

            for (int j=0;j<matrix_size;j++){
               System.out.print(m[i][j] +" ");
            }
            System.out.print("\n");
        }


           int level=0;
           int totallevel=matrix_size/2;
          int last = matrix_size - 1;
           while (level<totallevel) {

               for (int j = level; j < last; j++) {
                   int top = m[level][j];
                   swap(m, level,j, j,last);
                   swap(m, level,j, last,last-j+level);
                   swap(m, level,j, last-j+level,level);

               }
               level++;
               last--;

           }


        System.out.println("after swap array");
        for(int i=0;i<matrix_size;i++){

            for (int j=0;j<matrix_size;j++){
                System.out.print(m[i][j] +" ");
            }
            System.out.print("\n");
        }

        System.out.println(" array Length"+m.length);
    }


    public static void swap(int [][] arr,int i0,int j0,int i1,int j1){
       int temp=arr[i0][j0];
        arr[i0][j0]=arr[i1][j1];
        arr[i1][j1]=temp;
    }

}
