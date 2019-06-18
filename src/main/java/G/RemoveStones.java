package G;
import java.util.*;
public class RemoveStones {
    public static void main(String[] args) {
        int [][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(new RemoveStones().removeStones(stones));
    }
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(20000);
        for(int [] stone :stones){
            dsu.unioun(stone[0],stone[1]+10000);
        }
        Set<Integer> seen = new HashSet();
        for (int[] stone: stones)
            seen.add(dsu.find(stone[0]));
        System.out.println(seen.size());
        return stones.length - seen.size();

    }

    class DSU{
        int parent[];
        DSU(int size){
            parent= new int[size];
            for(int i=0;i<size;i++) parent[i]=i;
        }
        public int find(int x){
            if(x!=parent[x]) parent[x]=find(parent[x]);
            return parent[x];
        }
        public void unioun(int x,int y){
            parent[find(x)]=find(y);
        }
    }

}
