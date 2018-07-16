package G.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class RedundantDirectedConnection {

    public static void main(String arg[]){
       int[][] Input1 = {{1,2}, {1,3}, {2,3}};
       // int[][] Input2 = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        int[][] Input3 = {{2,1}, {3,1}, {4,2}, {1,4}};
        int [][] Input = {{1,2},{2,3},{3,1},{4,1}};
        int[] ans = new RedundantDirectedConnection().findRedundantDirectedConnection(Input);
        System.out.println(ans[0]+","+ans[1]);

    }
    public int[] findRedundantDirectedConnection(int[][] edges) {

        HashMap<Integer, Integer> findDuplicate = new HashMap<Integer, Integer>();
        HashMap<Integer, ArrayList<Integer>> keyValue = new HashMap<Integer, ArrayList<Integer>>();
        boolean twoParent = false;
        // find 2 parent;
        int[] lastDuplicate = new int[2];
        for (int[] edge : edges) {
            if (!findDuplicate.containsKey(edge[1])) {
                findDuplicate.put(edge[1], edge[0]);
            } else {
                lastDuplicate = edge;
                twoParent = true;
            }
            if (!keyValue.containsKey(edge[0])) {
                keyValue.put(edge[0], new ArrayList<Integer>());
            }
            keyValue.get(edge[0]).add(edge[1]);
        }

        // find cycle

        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Integer> q = new LinkedList<>();
        boolean cycle = false;
        int[] lastValue = new int [2];
        q.offer(edges[0][0]);
        visited.add(edges[0][0]);
        while(!q.isEmpty() && (!cycle)){
           int current = q.poll();
           visited.add(current);
           ArrayList<Integer> ls = keyValue.get(current);
           if(ls!=null ) {
               for (int ch : ls) {
                   if (!visited.contains(ch)) {
                       q.offer(ch);

                   } else {
                       cycle = true;
                       lastValue[0] = current;
                       lastValue[1] = ch;
                       break;
                   }
               }
           }

    }
    if(twoParent && (!cycle)){
       return lastDuplicate;
    }
    if((!twoParent) && cycle){
            return lastValue;
     } else

         return dfs(lastValue,new HashSet<Integer>(),keyValue  );






    }

    public int [] dfs(int [] node , HashSet<Integer> seen, HashMap<Integer, ArrayList<Integer>> keyValue ){
        int[] ans = new int[2];

        ArrayList<Integer> ls =keyValue.get(node[0]);
        int value=node[1];
        seen.add(value);
        while(true){
            ls = keyValue.get(value);
            if(ls!=null){
                int nevalue = ls.get(0);
                ls.remove(0);
                ls.add(nevalue);
                if(!seen.contains(nevalue)){
                    seen.contains(nevalue);
                } else{
                    ans[0]=nevalue;
                    ans[1]=keyValue.get(nevalue).get(0);
                    break;
                }
                value = nevalue;

            }

        }
        return ans;
    }


}
