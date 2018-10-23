package miss;

import java.util.HashMap;
import java.util.HashSet;

public class UnquePath {
    static Tree root =null;

    public static void main(String[] args) {
        UnquePath obj = new UnquePath();
        obj.MakeTree();
        System.out.println(obj.solution(root));
    }
    public int solution(Tree T) {
        if(T==null) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
     //  int count = recursionUnquePath1(T,map);
     //  int count = recursionUnquePath(T,set);
        int count = recursionUnquePath2(T,set);
        for(int e : set){
            System.out.println(e);
        }
        return count;
    }

    private void MakeTree(){
        root = new Tree(1);
        root.l= new Tree(2);
        root.r=new Tree(3);
        root.l.l=new Tree(4);
        root.l.r=new Tree(5);
        root.r.r=new Tree(3);
        root.r.l=new Tree(6);
        root.r.l.r=new Tree(8);
        root.r.l.r.r=new Tree(82);
        root.r.r.r=new Tree(9);
        root.r.r.r.r=new Tree(10);
        root.r.r.r.r.r=new Tree(11);
        root.r.r.r.r.r.r=new Tree(3);
        root.r.r.r.r.r.r=new Tree(12);



    }


    private int recursionUnquePath1(Tree root, HashMap<Integer,Integer> map){
        if(root==null){
            return map.size();
        }
        int v1=0;
        if(map.containsKey(root.x)){
            v1 = map.get(root.x);
        }

        map.put(root.x,v1+1);

        int max = Math.max(recursionUnquePath1(root.l,map),recursionUnquePath1(root.r,map));
        int v2 = map.get(root.x);

        map.put(root.x,v2-1);
        if(map.get(root.x)==0){
            map.remove(root.x);
        }
        return max;

    }




    private int recursionUnquePath(Tree root, HashSet<Integer> set){
        if(root==null){
            return set.size();
        }
        set.add(root.x);

        int max = Math.max(recursionUnquePath(root.l,set),recursionUnquePath(root.r,set));

        set.remove(root.x);
        return max;

    }

    private int recursionUnquePath2(Tree root, HashSet<Integer> set){
        if(root==null ){
            return set.size();
        }
        if(set.contains(root.x)){
            return set.size();
        }
        set.add(root.x);

        int max = Math.max(recursionUnquePath2(root.l,set), recursionUnquePath2(root.r,set));

        set.remove(root.x);
        return max;

    }

}

