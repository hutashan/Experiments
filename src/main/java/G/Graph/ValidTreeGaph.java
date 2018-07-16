package G.Graph;

import scala.Int;

import java.util.*;

public class ValidTreeGaph {




    public static void main(String arg[]){
        int n = 5;
        int [][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println(new ValidTreeGaph().validTree1(n,edges));
    }

    public boolean validTree(int n, int[][] edges) {
        // n must be at least 1
        if (n < 1) return false;

        // create hashmap to store info of edges
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<Integer>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // bfs starts with node in label "0"
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int top = queue.remove();
            // if set already contains top, then the graph has cycle
            // hence return false
            if (set.contains(top)) return false;

            for (int node : map.get(top)) {
                queue.add(node);
                // we should remove the edge: node -> top
                // after adding a node into set to avoid duplicate
                // since we already consider top -> node
                map.get(node).remove(top);
            }
            set.add(top);
        }
        return set.size() == n;
    }

    public boolean validTree1(int n, int[][] edges) {
        HashMap <Integer , HashSet<Integer>> map =  new HashMap<Integer , HashSet<Integer>> ();
        for(int i=0; i<n; i++){
            HashSet<Integer> list = new HashSet<Integer>();
            map.put(i, list);
        }

        for (int [] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        HashSet <Integer> hs = new HashSet<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int top = queue.remove();
            if(hs.contains(top)){
                return false;
            }

            for (int node : map.get(top)) {
                queue.add(node);
                // we should remove the edge: node -> top
                // after adding a node into set to avoid duplicate
                // since we already consider top -> node
                map.get(node).remove(top);
            }
            hs.add(top);

        }
        return hs.size()==n;
    }

}
