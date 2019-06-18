package G;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        String s  = "catsandog";
        List<String> wordDic  = new ArrayList<>();
        wordDic.add("cats");
        wordDic.add("dog");
        wordDic.add("sand");
        wordDic.add("and");
        wordDic.add("cat");
        System.out.println(new Solution().wordBreak(s,wordDic));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s,wordDict,0,new Boolean[s.length()]);
    }
    public boolean wordBreakHelper(String s, List<String> wordDict,int index,Boolean[] memo) {
        if(s.length()==index) return true;
        if(memo[index]!=null) return memo[index];
        memo[index]=false;
        for(String word: wordDict){
            int len = word.length();
            int end = index+len;
            if(end>s.length()) continue;
            if(s.substring(index,end).equals(word)){
                if(wordBreakHelper(s,wordDict,end,memo)){
                    memo[index]= true;
                    break;
                }
            }
        }
        return  memo[index];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        String s1 = s.substring(start, end);
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }




}


