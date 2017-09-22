package arr;


public class FindMaximumContSeqOfOne {

    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,0,1,1,1,1,0,0};


    int max=0;
     int st=0,tempmax=0,tempst=0;
        int end=0;
        int k=1,zero=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
                zero++;
            if( k>zero){
                tempmax=tempmax+1;
                max=Math.max(max,tempmax);
                end=i;
            } else {
                tempmax=0;
                zero=-1;
            }

        }
        st=(end - max)+1;

        System.out.println("Max--> "+max + " St  "+ st +" end "+end);

    }




}
