package hardprob;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxChucks {
    public static void main(String arg[]){
    int [] arr = {1,1,0,0,1};
    System.out.println(maxChunksToSorted11(arr));
    }
    static public int maxChunksToSorted(int[] arr) {
        int [] maxChucks = new int[arr.length];
        maxChucks[0]=arr[0];
        for (int i=1;i<arr.length;i++){
            maxChucks[i]=Math.max(maxChucks[i-1],arr[i]);
        }
        int result=0;
        for (int i=0;i<arr.length;i++){
            if(maxChucks[i]==i){
                result++;
            }
        }
        return result;
    }
    static public int maxChunksToSorted11(int[] arr) {
            Map<Integer, Integer> count = new HashMap();
            int ans = 0, nonzero = 0;

            int[] expect = arr.clone();
            Arrays.sort(expect);

            for (int i = 0; i < arr.length; ++i) {
                int x = arr[i], y = expect[i];


                if (count.containsKey(x)){
                    int vale = count.get(x)+1;
                    count.put(x,vale);
                }else{
                    count.put(x,0);
                }
                if (count.get(x) == 0) nonzero--;
                if (count.get(x) == 1) nonzero++;

                if (count.containsKey(y)){
                    int vale = count.get(y)-1;
                    count.put(y,vale);
                } else{
                    count.put(y,0);
                }
                if (count.get(y) == -1) nonzero++;
                if (count.get(y) == 0) nonzero--;

                if (nonzero == 0) ans++;
            }

            return ans;
        }

}
