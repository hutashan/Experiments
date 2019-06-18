package F;

public class NextPermutation {
    public static void main(String[] args) {
        int [] input = {1,1,5};
        new NextPermutation().nextPermutation(input);
    }

    public void nextPermutation(int[] num){
        if(num == null || num.length ==0 || num.length ==1) return;
        int i = num.length-2;
        while(i>=0 && num[i]>=num[i+1]) i--;  // checking descending order
        if(i>=0){
            int j = num.length-1;
            while(num[i]>=num[j]) j--;
            swap(num,i,j);
        }
       reverse(num,i+1,num.length-1);

        for(int k=0;k<num.length;k++){
            System.out.println(num[k]);
        }

    }

    private void swap(int[] num,int i ,int j){
        int temp = num[i];
        num [i] = num [j];
        num[j]=temp;
    }

    private void reverse(int [] num,int i,int j){
        while(i<j)swap(num,i++,j--);
    }





}
