package G;

import java.util.HashSet;
import java.util.HashMap;

public class LengthOfLongestSubstringKDistinct {
    public static void main(String arg[]) {
        //String input = "bacc";
        String input ="eceba";
        System.out.println(new LengthOfLongestSubstringKDistinct().lengthOfLongestSubstringKDistinct(input, 2));


    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k<=0){
            return 0;
        }
        if(s.length()<=k){
            return s.length();
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int start=0,end=0,maxlen=0;
        while(end<s.length()&& ((s.length() - start + 1) > maxlen)){
            Character c = s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size()>k){
                while(k<map.size() && start < end){
                    Character c1 = s.charAt(start);
                    map.put(c1,map.get(c1)-1);
                    if(map.get(c1)==0){
                        map.remove(c1);
                    }
                    start++;
                }

            }
            maxlen=Math.max(maxlen,end-start+1);
            end++;

        }
        return maxlen;
    }


}
