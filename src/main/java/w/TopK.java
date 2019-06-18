package w;

import java.util.*;

public class TopK {

    public static void main(String[] args) {
        String [] sr = {"apple","pear","Man","Man","te","te","starr"};
        HashMap<String,Integer> map = new HashMap<>();

        for(String word : sr){
            if(!map.containsKey(word)){
                map.put(word,1);
            } else{
                map.put(word,map.get(word)+1);
            }

        }

        TreeMap<String, Integer> sortedMap = sortMapByValue(map);
        System.out.println(sortedMap);


    }
    public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
        Comparator<String> comparator = new ValueComparator(map);
        TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
        result.putAll(map);
        return result;
    }
}
class ValueComparator implements Comparator<String>{

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public ValueComparator(HashMap<String, Integer> map){
        this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
        if(map.get(s1) > map.get(s2)){
            return -1;
        }else if (map.get(s1) < map.get(s2)){
            return 1;
        }else{
            return s2.compareTo(s1);
        }
    }
}



