package a;

import collections.KeyMapAsSet;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph,banned));

    }
    public String mostCommonWord1(String paragraph, String[] banned) {
        if(paragraph==null || paragraph.length()==0) return null;
        Set<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(banned));
        Map <String,Integer> map = new HashMap<String ,Integer>();
        String[] arrayPara = paragraph.split("[ !?',;.]+");
        for(String word : arrayPara){
            String lowerWord = word.toLowerCase();
            if(!set.contains(lowerWord)){
                map.put(lowerWord,map.getOrDefault(lowerWord,0)+1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> pr = new PriorityQueue<Map.Entry<String,Integer>>((a,b)-> (Integer.compare(b.getValue(),a.getValue())) );
        for(Map.Entry<String,Integer> mp : map.entrySet()){
            pr.add(mp);
        }
        return pr.poll().getKey();
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }
    class KeyVal{
        int key;
        String val;
        KeyVal(int k,String v){
            key=k;
            val=v;
        }
    }
}
