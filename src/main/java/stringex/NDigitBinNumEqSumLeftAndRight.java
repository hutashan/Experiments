package stringex;

/**
 * find-n-digit-binary-numbers-equal-sum-bits-two-halves
 */
public class NDigitBinNumEqSumLeftAndRight {

    public static void main(String arg[]){
        int n=7;
        String left="",right ="";
        binarySeq(left,right,n,0);

    }
    public static void binarySeq(String left,String right,int n, int diff ){
        if (n>9){
            return;
        }
        if(n>0) {
            if (n == 1) {
                binarySeq(left, "0" + right, 0, diff);
                binarySeq(left, "1" + right, 0, diff);
                return;
            }
            if (left != "") {
                binarySeq(left + "0", right + "0", n - 2, diff);
                binarySeq(left + "0", right + "1", n - 2, diff - 1);
            }
            binarySeq(left + "1", right + "0", n - 2, diff + 1);
            binarySeq(left + "1", right + "1", n - 2, diff);
        }
        if (n==0 && diff ==0){
            System.out.println(left+right);
        }
    }

}
