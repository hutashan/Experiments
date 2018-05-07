package arr;

public class NumSubarrayBoundedMax {
    public static void main(String arg[]){
        int [] aerr = {2,9,2,5,6};
        System.out.println(numSubarrayBoundedMax(aerr,2,8));
    }
    static public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = 0;
        int cur = 0;
        int  count=0;
        int pre =0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= R) {
                len++;
            } else {
                len =0;
            }
            if (A[i] >= L && A[i] <= R) {
                cur=len;
            }else  if  (A[i] < L) {
                cur = pre;
            }
                count=count+cur;
                pre=cur;
                cur=0;


        }
        return count;
    }
}
