package stringprob;

import datastructure.TriesNode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by parmana on 7/31/17.
 */
public class LongestCommonPrefix {

    TriesNode root=new TriesNode();

    public static void main(String[] args) {

        String arr[]={"codable","code","coder","coding"};
        LongestCommonPrefix obj = new LongestCommonPrefix();
        for(String s:arr){
            obj.add(s);
        }
        //System.out.println(obj.root);
       // obj.printCommonString();
        obj.printAllWord(obj.root);

    }



    public void add(String str){

        HashMap<Character,TriesNode> dic=root.dict;
        TriesNode t;
      int len =str.length();

        for(int i=0;i<len;i++){
         Character c= str.charAt(i);
            if(dic.containsKey(c)){
                 t= dic.get(c);
                dic=t.dict;
            } else {
                 t=new TriesNode();
                dic.put(c,t);
                dic=t.dict;
            }
            if(i==len-1){
             t.isleaf=true;
             t.key=str;
            }
        }
    }

    public void printCommonString(){

        HashMap<Character,TriesNode> dic=root.dict;

        while(dic.size()==1){
            System.out.println(dic.keySet().iterator().next());
            dic= dic.values().iterator().next().dict;
        }

    }

    public void printAllWord(TriesNode t1 ){
        HashMap<Character,TriesNode> dic=t1.dict;

        if(dic.size()==0)
            return;

       Iterator<Character> itr= dic.keySet().iterator();
        while (itr.hasNext()){
          TriesNode t=  dic.get(itr.next());
          if(t.isleaf){
              System.out.println(t.key);
          }
            printAllWord(t);
        }

        /*while(dic.size()>1){
            System.out.println(dic.keySet().iterator().next());
            dic= dic.values().iterator().next().dict;
        }*/
    }

}
