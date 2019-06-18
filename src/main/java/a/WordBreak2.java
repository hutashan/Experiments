package a;
import java.util.*;


public class WordBreak2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
       // "cat", "cats", "and", "sand", "dog"
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");




        System.out.println(new WordBreak2().wordBreak("catsanddog",set));
    }
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
