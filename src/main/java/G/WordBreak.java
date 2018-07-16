package G;

import java.util.List;

public class WordBreak {
    public static void main(String arg[]){


    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakUtil(s,wordDict,0,new Boolean[s.length()]);

    }
    public boolean wordBreakUtil1(String s ,List<String> wordDict,int index ){
        if(index == s.length())
            return true;
       for(String word:wordDict){
           int len = word.length();
           int end = index + len;
           if(end>s.length()){
               continue;
           }
           if(s.substring(index,end).equals(word)){
               if(wordBreakUtil1(s,wordDict,index+len)){
                   return true;
               }
           }
       }
       return false;
    }


    public boolean wordBreakUtil(String s ,List<String> wordDict,int index, Boolean[]  memo){
        if(index == s.length())
            return true;
        if(memo[index]!=null){
            return memo[index];
        }
        memo[index]=false;
        for(String word:wordDict){
            int len = word.length();
            int end = index + len;
            if(end>s.length()){
                continue;
            }
            if(s.substring(index,end).equals(word)){
                if(wordBreakUtil(s,wordDict,index+len,memo)){
                    memo[index]=true;
                    break;
                }
            }
        }
        return memo[index];
    }

}
