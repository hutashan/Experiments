package Barclay;


public class MinimumElement {
    public static void main(String[] args) {
        int [] arr = {10,2,3,4,2};
        System.out.println(new MinimumElement().solution(arr));
    }
    int solution(int[] A) {
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }

}
