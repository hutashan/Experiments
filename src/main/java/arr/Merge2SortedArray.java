package arr;

public class Merge2SortedArray {

    public static void main(String arg[]){

        int [] a = {1,3,4,5,8};
        int [] b ={2,6};
//        sortArray(a,5,b,2);
        merge(a,5,b,2);
    }

    public static int[] sortArray(int [] a,int n,int[] b, int m){

        int i=n-1;
        int j=m-1;
        int k = n+m-1;
        int[] newA = new int[k+1];
        while (i>-1 && j>-1){
            if (a[i]>b[j]){
                newA[k--]=a[i--];
            } else {
                newA[k--]=b[j--];
            }

        }

        while(j>-1){
            newA[k--]=b[j--];
        }
        while(i>-1){
            newA[k--]=a[i--];
        }
        return newA;
    }
   static public void merge(int A[], int m, int B[], int n) {

        int i=m-1, j=n-1, k=m+n-1;
       int[] newA = new int[k+1];
        while (i>-1 && j>-1) newA[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
        while (j>-1)         newA[k--]=B[j--];

    }

}
