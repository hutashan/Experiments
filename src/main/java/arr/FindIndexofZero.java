package arr;


public class FindIndexofZero {
    public static void main (String[] args)
    {
        int arr[] = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };

        int index = findIndexofZero(arr);

        if (index != -1)
            System.out.print("Index to be replaced is " + index);
        else
            System.out.print("Invalid input");
    }
    public static int findIndexofZero(int arr[])
    {
        int n = arr.length;
        int left =0;
        int count =0;
        int maxCount =0;
        int max_index =-1;
        int prev_zero_index = -1;
        for (int i=0;i<n-1;i++){
            if (arr[i]==0){
                prev_zero_index = i;
                count++;
            }
            if (count ==2){
               while(arr[left]==0){
                   left++;
               }
                left++;
                count=1;
            }
            if(i-left+1>maxCount){
                maxCount =i-left+1;
                max_index=prev_zero_index;
            }
        }
        return max_index;
    }

}
