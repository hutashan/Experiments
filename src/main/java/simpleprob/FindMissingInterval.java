package simpleprob;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by parmana on 3/9/17.
 */
public class FindMissingInterval {

   /* posibleStart = first_interval_value
    if(posibleStart > currentkey and posibleStart < currentval){
        posibleStart=currentval
    } else if(posibleStart > currentkey and  posibleStart >= currentval){
        no change in possible start
    } else if(posibleStart<currentkey){
        list add(posibleStart,currentkey)
        posibleStart=currentval
    } else{
        posibleStart=currentval
    }*/

    public static void main(String[] args) {

        TreeMap<Integer,Integer> output= new  TreeMap<Integer,Integer>();

        TreeMap<Integer,Integer> tr= new  TreeMap<Integer,Integer>();
        tr.put(2,6);
        tr.put(9,12);
        tr.put(8,9);
        tr.put(18,21);
        tr.put(4,7);
        tr.put(10,11);
        tr.put(22,30);
        int posibleStart=0;
       Set t= tr.keySet();
       Iterator itr= t.iterator();
        while (itr.hasNext()){
              int key= (Integer)itr.next();
             int val = tr.get(key);
            if(posibleStart!=0){
                 if(posibleStart>key && posibleStart<val){
                     posibleStart=val;
                 }else if(posibleStart>key && posibleStart >= val) {
                     posibleStart=posibleStart;
                 } else if(posibleStart<val & posibleStart!=key){
                     output.put(posibleStart,key);
                     posibleStart=val;
                 }else {
                     posibleStart=val;
                 }
            } else {
                posibleStart=val;
            }
            System.out.println(key+" "+tr.get(key));
        }
        System.out.println(output.toString());
    }
}
