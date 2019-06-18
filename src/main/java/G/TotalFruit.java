package G;
import java.util.*;

import java.util.HashSet;

public class TotalFruit {
    public static void main(String[] args) {
        int [] trees = {1,2,3,2,2};
        System.out.println(new TotalFruit().totalFruit(trees));
    }
    public int totalFruit(int[] tree) {
        if(tree==null|| tree.length==0) return 0;
        int left =0;
        int max_so_far = 0;
        int i=0;
        Map<Integer,Integer> set = new HashMap<>();
        int prev =tree[i];
        while(i<tree.length){

            if(!set.containsKey(tree[i])){
                set.put(tree[i],i);
            } else{
                if(prev!=tree[i]){
                    set.put(tree[i],i);
                }
            }
            if(set.size()>=3){

               max_so_far=Math.max((i-left),max_so_far);
               left =set.get(tree[i-1]);
               i=left;
                set=new HashMap<>();

            } else{
                prev=tree[i];
                i++;

            }
        }
        return Math.max((i-left),max_so_far);
    }
}
