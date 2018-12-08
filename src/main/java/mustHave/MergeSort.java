package mustHave;

public class MergeSort {
    public static void main(String[] args) {
        int [] input = {2,5,3,8,1,7,9};
        int [] output = new MergeSort().mergeSort(input);
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }
    }
    public int[] mergeSort(int [] input){
        if(input.length<2){
            return input;
        }
        int mid = input.length/2;
        int [] left = new int[mid];
        int [] right = new int[input.length-mid];

        for(int i=0;i<mid;i++){
            left[i]=input[i];
        }

        for(int i=mid;i<input.length;i++){
            right[i-mid]=input[i];
        }
        mergeSort(left);
        mergeSort(right);
      return   merge(left,right,input);
    }

    public int [] merge(int[] left,int[] right,int [] output){
        int i=0;
        int j=0;
        int k =0;
        while(i<=left.length-1 && j <= right.length-1){
            if(left[i]<right[j]){
                output[k]=left[i];
                i++;
                k++;
            }else {
                output[k]=right[j];
                k++;
                j++;
            }
        }
        while(i<=left.length-1){
            output[k]=left[i];
            i++;
            k++;
        }
        while(j<=right.length-1){
            output[k]=right[j];
            j++;
            k++;
        }
        return output;
    }

}
