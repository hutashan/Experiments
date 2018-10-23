package M;

public class SortColors {
    public static void main(String[] args) {
      //  int[] input = {2,0,2,1,1,0};
        int[] input = {0,0,0,2,2,0};
        new SortColors().sortColors(input);
    }
    void sortColors(int A[]) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == 0)
            {
                A[++n2] = 2;
                A[++n1] = 1;
                A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n2] = 2;
                A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
                A[++n2] = 2;
            }
        }
    }






}
