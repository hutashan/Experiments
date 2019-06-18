package G;

import java.lang.reflect.Array;

public class FindRedundantConnection {
    public static void main(String[] args) {
        int [] [] input = {{1,2}, {1,3}, {2,3}};
        System.out.println(~10);
        FindRedundantConnection f = new FindRedundantConnection();
        int[] a = f.findRedundantConnection(input);
        for(int i : a){
            System.out.println(i);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int [] returnArr = new int[2];
        DSU d = new DSU(100);
        for(int [] edge : edges){
            if(!d.unioun(edge[0],edge[1])){
                returnArr[0]=edge[0];
                returnArr[1]=edge[1];
            }
        }
        return returnArr;

    }
    class DSU {
        int [] rank ;
        int [] parent;
        DSU(int size){
            rank = new int [size];
            parent=new int [size];
            for(int i=0;i<size;i++) parent[i]=i;

        }
        int find (int x){
            if(x!=parent[x])
                parent[x]=find(parent[x]);
            return parent[x];
        }
        boolean unioun(int x,int y){
           int parentx= find(x);
           int parenty= find(y);
           if(parentx==parenty) return false;
           if(rank[parenty]>rank[parentx]) {
               rank[parenty]=rank[parenty]+1;
               parent[parentx]=parenty;
           } else{
               rank[parentx]=rank[parentx]+1;
               parent[parenty]=parentx;
           }
           return true;
        }

    }

}
