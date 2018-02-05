package arr;


public class FindOddOccuring {


    public static void main(String[] args) {

      int[] arr={4,3,6,2,6,4,2,3,4,3,3};
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];
        }

        System.out.println(xor);

    }
}
