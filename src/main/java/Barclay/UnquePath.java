package Barclay;

import java.util.HashMap;

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
        int count = recursionUnquePath(T,map);

        return count;
    }

    private void MakeTree(){
        root = new Tree(1);
       Tree rl1= new Tree(2).l=new Tree(4);
        root.l=rl1;
        rl1.r=new Tree(5);
        Tree rr1= new Tree(3);
        root.r = rr1;
        rr1.l=new Tree(3).r= new Tree(9);
        rr1.r=new Tree(6).r = new Tree(8);

    }




    private int recursionUnquePath(Tree root,HashMap<Integer,Integer> map){
        if(root==null){
            return map.size();
        }
        int v1=0;
        if(map.containsKey(root.x)){
            v1 = map.get(root.x);
        }

        map.put(root.x,v1+1);

        int max = Math.max(recursionUnquePath(root.l,map),recursionUnquePath(root.r,map));
        int v2 = map.get(root.x);

        map.put(root.x,v2-1);
        if(map.get(root.x)==0){
            map.remove(root.x);
        }
        return max;

    }
}

