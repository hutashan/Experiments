package arr;

class findDuplicate
{
    /*

    int actual_sum = std::accumulate(start, finish, 0);
    int expected_sum = size * (size - 1) / 2;

    return actual_sum - expected_sum;
     */


    public static int findDuplicate(int arr[])
    {

        int n = arr.length;

        int duplicate = -1;

        for (int i = 0; i < n; i++)
        {
            int absVal = (arr[i] < 0) ? -arr[i] : arr[i];

            if (arr[absVal - 1] >= 0)
                arr[absVal - 1] = -arr[absVal - 1];
            else
            {
                duplicate = absVal;
                break;
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (arr[i] < 0)
                arr[i] = -arr[i];
        }

        return duplicate;
    }

    public static void main (String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 2 };

        System.out.println("Duplicate element is " + findDuplicate(arr));
    }
}