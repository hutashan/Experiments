package M;

import java.util.*;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
    int[] a = {1,3,7,9};
    int [] b ={22,24,25,26,20,30};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays1(a,b));
    }
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m =nums2.length;
        int min_index=0;
        int max_index=Math.min(n,m);
        int i=0,j=0;
        int [] a, b;
        int median =0;
        if(n<m){
             a = nums1;
             b =nums2;
            max_index = n;
        } else{
             a = nums2;
            b =nums1;
            max_index = m;
        }

        while(min_index<=max_index) {
            i = (min_index + max_index) / 2;
            j = ((n + m + 1) / 2) - i;
            if (i < max_index && j > 0 && b[j - 1] > a[i]) {
                int A = a[i];
                int B = b[j - 1];
                min_index = i + 1;
            }
            else if (i > min_index && j < m && b[j] < a[i - 1]) {
                int A = a[i-1];
                int B = b[j];
                max_index = i - 1;
            }
            else {
                if (i == 0)
                    median = b[j - 1];
                else if (j == 0)
                    median = a[i - 1];
                else
                    median = Math.max(a[i - 1],
                            b[j - 1]);
                break;
            }
        }
        if ((n + m) % 2 == 1)
            return (double)median;
        if (i == m)
            return (median + b[j]) / 2.0;
        if (j == n)
            return (median + a[i]) / 2.0;

        return (median + Math.min(a[i],
                b[j])) / 2.0;

    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
