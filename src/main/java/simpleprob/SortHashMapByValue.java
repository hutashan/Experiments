package simpleprob;

import java.util.*;

/**
 * Created by parmana on 3/16/17.
 */
public class SortHashMapByValue {

    public static void main(String[] args) {
       Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("na",4);
        map.put("na1",2);
        map.put("na3",6);
        sort(map);
    }


    public static void sort(Map<String,Integer> map){

        List <Map.Entry<String, Integer>> list = new LinkedList(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return ( o2.getValue() ).compareTo( o1.getValue() );
            }
        });
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }

        Set s=result.keySet();
        Iterator itr = s.iterator();

        while (itr.hasNext()){
            String key = (String)itr.next();
            System.out.println(key+" "+result.get(key));

        }


    }

}
