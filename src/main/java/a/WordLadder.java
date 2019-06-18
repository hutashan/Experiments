package a;
import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String begin ="hit";
        String end = "cog";
        List<String> dic = new ArrayList<>();
        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");
    //    dic.add("cog");
        System.out.println(new WordLadder().ladderLength1(begin,end,dic));

    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList1) {
        Set<String> wordList = new HashSet<String>(wordList1);
        Set <String> reached = new HashSet<>();
        reached.add(beginWord);
      //  wordList.add(endWord);
        int distance =1;
        while(!reached.contains(endWord)){
            Set<String> toAdd = new HashSet<String>();
            for(String word : reached){
                for(int i=0;i<word.length();i++){
                    char[] chars = word.toCharArray();
                    for(char ch='a'; ch<'z';ch++){
                        chars[i]=ch;
                        String newWord = new String (chars);
                        if(wordList.contains(newWord)){
                            toAdd.add(newWord);
                            wordList.remove(newWord);
                        }

                    }
                }
            }

            if(toAdd.size()==0) return 0;
            reached=toAdd;
            distance++;
        }

        return distance;

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> allowed = new HashSet<>(wordList);
        if (!allowed.contains(endWord)) {
            return 0;
        }
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);
        return length(begin, end, allowed, 1);
    }

    private int length(Set<String> begin, Set<String> end, Set<String> allowed, int length) {
        if (begin.size() > end.size()) {
            // bidirectional search for efficiency; always expand smaller side
            return length(end, begin, allowed, length);
        }
        Set<String> nextBegin = new HashSet<>();
        for (String beginWord : begin) {
            char[] characters = beginWord.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                char savedCh = characters[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    characters[i] = ch;
                    String word = new String(characters);
                    if (end.contains(word)) {
                        return length + 1;
                    } else if (allowed.remove(word)) {
                        nextBegin.add(word);
                    }
                }
                characters[i] = savedCh;
            }
        }
        if (nextBegin.size() == 0) {
            return 0;
        }
        return length(nextBegin, end, allowed, length + 1);
    }



}
