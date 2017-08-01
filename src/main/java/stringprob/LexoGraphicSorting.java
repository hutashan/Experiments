package stringprob;

import datastructure.TriesNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by parmana on 7/24/17.
 */
public class LexoGraphicSorting {

  TriesNode root = new TriesNode();

    public static void main(String[] args) {
     String[] arr= {
             "lexicographic", "sorting", "of", "a", "set", "of", "keys", "can", "be",
             "accomplished", "with", "a", "simple", "trie", "based", "algorithm",
             "we", "insert", "all", "keys", "in", "a", "trie", "output", "all",
             "keys", "in", "the", "trie", "by", "means", "of", "preorder",
             "traversal", "which", "results", "in", "output", "that", "is", "in",
             "lexicographically", "increasing", "order", "preorder", "traversal",
             "is", "a", "kind", "of", "depth", "first", "traversal"};
        String arr1[]={"codable","code","coder","coding"};
        LexoGraphicSorting obj = new LexoGraphicSorting();
        for(String s:arr){
            obj.insert(s);
        }

        obj.printWord(obj.root);
    }




    public  void insert(String word){

       HashMap<Character,TriesNode> dic = root.dict;
        int len= word.length();
        TriesNode t;
        for(int i=0;i<len;i++){
        Character c= word.charAt(i);
        if(dic.containsKey(c)){
            t= dic.get(c);
            dic=t.dict;
        } else {
            t= new TriesNode();
            dic.put(c,t);
            dic=t.dict;
        }
            if(i==len-1){
                t.isleaf=true;
                t.key=word;
            }

        }

    }


    public void printWord(TriesNode t1){

        if(t1.dict.size()==0)
            return;

        Iterator<Character> itr= t1.dict.keySet().iterator();
        while (itr.hasNext()){
            TriesNode t= t1.dict.get(itr.next());
            if(t.isleaf){
                System.out.println(t.key);
            }
            printWord(t);

        }


    }


}


