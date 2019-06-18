package mustHave;

public class QuickSort {
    public static void main(String[] args) {
        int [] input = {2,5,3,8,1,7,9};
       int [] a = new QuickSort().quickSort(input);
       for(int i=0;i<a.length;i++){
           System.out.println(a[i]);
       }

    }
    public int [] quickSort(int [] input){
       return quickSort(input,0,input.length-1);
    }

    public int [] quickSort(int [] input,int left,int right){
        if(left>=right){
            return input;
        }
        int pivot = input[(right+left)/2];
        int partition = partion(input,left,right,pivot);
        quickSort(input,left,partition-1);
        quickSort(input,partition,right);
        return input;
    }
    public int partion(int [] input,int left,int right,int pivot){
       while(left<=right){
           while(input[left]<pivot){
               left++;
           }
           while(input[right]>pivot){
               right--;
           }
           if(left<=right){
               swap(input,right,left);
               left++;
               right--;
           }

       }
      return left;
    }
    public void swap(int[] input,int right, int left){
        int temp = input[right];
        input[right]=input[left];
        input[left]= temp;

    }
}
