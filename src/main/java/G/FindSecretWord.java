package G;
import javafx.util.Pair;

import java.util.*;


public class FindSecretWord {
    public static void main(String[] args) {
        String [] input = {"acckzz","ccbazz","eiowzz","abcczz","mmmmmm"};
        new FindSecretWord().findSecretWord(input);
    }
    public void findSecretWord(String[] wordlist) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist)
                for (String w2 : wordlist)
                    if (match(w1, w2) == 0)
                        count.put(w1, count.getOrDefault(w1 , 0) + 1);
            Pair<String, Integer> minimax = new Pair<>("", 1000);
            for (String w : wordlist)
                if (count.getOrDefault(w, 0) < minimax.getValue())
                    minimax = new Pair<>(w, count.getOrDefault(w, 0));
            x = 3;
            List<String> wordlist2 = new ArrayList<String>();
            for (String w : wordlist)
                if (match(minimax.getKey(), w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[0]);
        }
    }
    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i) if (a.charAt(i) == b.charAt(i)) matches ++;
        return matches;
    }
}
