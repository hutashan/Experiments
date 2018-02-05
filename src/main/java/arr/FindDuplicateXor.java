package arr;

/**
 * Created by v708178 on 10/14/17.
 */
public class FindDuplicateXor {

        // Function to find a duplicate element in a limited range array
        public static int findDuplicate(int A[])
        {
            // n is length of the array
            int n = A.length;

            int XOR = 0;

            // take xor of all array elements
            for (int i = 0; i < n; i++)
                XOR ^= A[i];

            // take xor of numbers from 1 to n-1
            for (int i = 1; i <= n - 1; i++)
                XOR ^= i;

            // same elements will cancel out each other as a ^ a = 0,
            // 0 ^ 0 = 0 and a ^ 0 = a

            // xor will contain the missing number
            return XOR;
        }

        // main function
    public static void main (String[] args)
    {
        // input array contains n numbers between [1 to n - 1]
        // with one duplicate
        int arr[] = { 1, 2, 3, 4, 4 };

        System.out.println("Duplicate element is " + findDuplicate(arr));
    }
}
