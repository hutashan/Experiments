package arr;

public class MedianTwoArray {

    /*


    1) Calculate the medians m1 and m2 of the input arrays ar1[]
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 is greater than m2, then median is present in one
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
     */


    public static void main (String a[]){
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 == n2)
            System.out.println("Median is " +
                    getMedianSameSize(ar1, ar2, n1));
    }
    static int getMedianSameSize(int ar1[], int ar2[], int n)
    {
        int i = 0;
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        for (count = 0; count <= n; count++)
        {
            if (i == n)
            {
                m1 = m2;
                m2 = ar2[0];
                break;
            }
            else if (j == n)
            {
                m1 = m2;
                m2 = ar1[0];
                break;
            }

            if (ar1[i] < ar2[j])
            {
                m1 = m2;
                m2 = ar1[i];
                i++;
            }
            else
            {
                m1 = m2;
                m2 = ar2[j];
                j++;
            }
        }

        return (m1 + m2)/2;
    }
}
