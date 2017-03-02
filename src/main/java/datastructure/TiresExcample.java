package datastructure;

import java.util.HashMap;

/**
 * Created by parmana on 2/22/17.
 */
public class TiresExcample {
     TriesNode root;

  public TiresExcample(){
      root= new TriesNode();
  }

// abc
    public  void add(String s){

        HashMap <Character,TriesNode> dic= root.dict;

        int len= s.length();
        for(int i = 0;i< len;i++){
            TriesNode t;
            char c = s.charAt(i);
            if(dic.containsKey(c)){
              t=dic.get(c);

            } else {
              t= new TriesNode();
              dic.put(c,t);

            }
            dic=t.dict;
            if(i==len-1){
                t.isleaf=true;
            }
        }

        /*if(root!=null){
            root.dict.containsKey()

        } else {
            root = new TriesNode();
            root.c=s.charAt(index);
            if(s.length()==index){
                return ;
            } else {
                add(s,index+1);
            }

        }*/

        System.out.println("added");

    }


   public TriesNode serach(String word){

       HashMap <Character,TriesNode> dic=root.dict;
       TriesNode t=null;
         for(int i=0;i<word.length();i++ ){

             char c= word.charAt(i);
             if(dic.containsKey(c)){
                 t=dic.get(c);
                 dic=dic.get(c).dict;

             } else {
                 t=null;
             }

         }
       return t;
   }


    public static void main(String[] args) {

        TiresExcample t= new TiresExcample();

        t.add("naren");
        t.add("apple");

       TriesNode t1= t.serach("nare");

        if(t1!=null && t1.isleaf){
            System.out.println("Found");
        } else {

            System.out.printf("not found");
        }






    }


}
