package revise;
import java.util.*;

public class FindSubstring {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String [] d = {"foo","bar"};

        List<Integer> ls = new FindSubstring().findSubstring(s,d);
        for(Integer l :ls){
            System.out.println(l);
        }

    }
    public List<Integer> findSubstring(String s, String[] words) {
        final List<Integer> indexes = new ArrayList<>();
        if(s==null || s.length()==0 || words==null || words.length==0) return indexes;
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
