package a;
import java.util.*;
public class topKFrequent {
    public static void main(String[] args) {
        String [] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> ls = new topKFrequent().topKFrequent(words,2);
        for(String l : ls){
            System.out.println(l);
        }
    }
    public List<String> topKFrequent1(String[] words, int k) {
        List<String> ls = new ArrayList();
        Map<String,Integer> map = new HashMap();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer> >pr = new PriorityQueue<Map.Entry<String,Integer> >( (x,y) -> (
                x.getValue()==y.getValue() ? x.getKey().compareTo(y.getKey()) :
                        y.getValue() - x.getValue()));
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            pr.add(entry) ;
        }
        for(int i=0;i<k;i++){
            ls.add(pr.poll().getKey());
        }
        return ls;
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;

        Map<String, Integer> map = new HashMap<>();
        for (String s: words) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        List<String> list = new ArrayList<>();

        for (String key : map.keySet()) {
            list.add(key);
        }

        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                if (map.get(a) == map.get(b)) {
                    return a.compareTo(b);
                } else {
                    return map.get(b) - map.get(a);
                }
            }
        });

        return list.subList(0, k);
    }
}
