package arr;

/**
 * Created by parmana on 9/13/17.
 */
public class FindMissingTerm {

    public static void main(String[] args) {
       // int[] arr = {5,7,9,11,15};
        //int[] arr = {5,7,9,11,13,17};
        int[] arr = {1,2,4,5,6,7};
        int l=0,h=arr.length-1;
        int d= (arr[h]-arr[0])/(h+1);
         while (l<=h){
            int m= (l+h)/2;
            if(m-1>=0 && ((arr[m]- arr[m-1])!=d)){
                System.out.println(arr[m]-d);
                return;
            }
            if(m+1<=h && ((arr[m+1]- arr[m])!=d)){
                System.out.println(arr[m]+d);
                return;
            }
            if((arr[m]-arr[l])!=m*d){
                h=m-1;
            } else {
                l=m+1;
            }
        }
    }

}

