package arr;


public class TemmoAttack {

public static void main(String a[]){
    int [] arr = {1,3};
    System.out.println(findPoisonedDuration(arr,2));

}



   static public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int begin = timeSeries[0], total = 0;
        for (int t : timeSeries) {
            total = total + (t < begin + duration ? t - begin : duration);
            begin = t;
        }
        return total + duration;
    }

}
