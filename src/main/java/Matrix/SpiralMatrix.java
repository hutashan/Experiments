package Matrix;


public class SpiralMatrix {
    static int [][] matrix;

    public static void main(String[] a){
       int M=8,N=10;
        matrix = new int [M][N];
        int top=0;
        int buttom =M-1;
        int right= N-1;
        int left =0;
        int flag=1;

        while(true){

            if(left>right){
                break;
            }
            for(int i=left;i<=right;i++){
                matrix[top][i]=flag;
            }
            top++;



            if(top>buttom)
                break;

            for(int i=top;i<=buttom;i++){
                matrix[i][right]=flag;
            }
            right--;


            if(left>right){
                break;
            }
            for(int i=right;i>=left;i--){
                matrix[buttom][i]=flag;
            }
            buttom--;



            if(top>buttom)
                break;

            for(int i=buttom;i>=top;i--){
                matrix[i][left]=flag;
            }

            left++;



            if(flag==0){
                flag=1;
            } else if(flag==1){
                flag=0;
            }


        }

        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }




    }
}
