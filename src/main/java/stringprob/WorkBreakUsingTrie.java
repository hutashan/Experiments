package stringprob;

import datastructure.TriesNode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by parmana on 8/1/17.
 */
public class WorkBreakUsingTrie {

     TriesNode root = new TriesNode();


    public static void main(String[] args) {

        WorkBreakUsingTrie obj = new WorkBreakUsingTrie();
        String[] arr ={ "this", "th", "is", "famous", "word", "break",
                "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "prob", "lem"};

        for(String str:arr){
            obj.insert(str);
        }
        //obj.printWord(obj.root);
        String str1 = "wordbreakproblem";
        System.out.println(obj.isWordAvailable(str1));


    }


    public boolean isWordAvailable(String word){

       int len= word.length();
        boolean[] good= new boolean[len+1];
        HashMap<Character,TriesNode> dic;

        good[0]=true;
        for (int i=0;i<len;i++){
            dic= root.dict;
            TriesNode t2=root;
             if(good[i]) {

                 for (int j = i; j < len; j++) {

                     if(dic.size()==0){
                         break;
                     }

                     char c1=word.charAt(j);
                     if(dic.containsKey(c1)){
                      TriesNode t1 =dic.get(word.charAt(j));
                      dic =t1.dict;
                       if(t1.isleaf) {
                           good[j + 1] = true;
                       }


                       } else {
                         break;
                     }

                 }
             }



        }

    /*for(boolean j:good){
        System.out.println(j);
    }*/
return good[len];
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
