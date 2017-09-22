package arr;


public class GetFloorAndCeil {




    public static void main(String[] args) {
        int arr[]={1,4,6,8,9};
        System.out.println(floor(arr, 5, 0, 4));
    }

    // higest element in array and lowest to x
    public static int floor(int[] arr,int x,int low,int high){


        if(x<arr[low])
            return -1;


        if(x>=arr[high])
            return arr[high];

        int mid= (low+high)/2;
        if(arr[mid]==x)
            return arr[mid];


        if(x<arr[mid]){
            return floor(arr,x,low,mid-1);
        } else {
           return   floor(arr,x,mid,high);
        }

    }

}
