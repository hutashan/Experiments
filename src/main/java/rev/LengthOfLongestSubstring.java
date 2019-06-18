package rev;


import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String input = "abccabcxbb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(input));
    }
    public int lengthOfLongestSubstring(String s) {
        if(s==null && s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int start =0,end=0,maxlen =0;
        while(end<s.length()){
            Character c = s.charAt(end);
            if(map.containsKey(c)){
                maxlen=Math.max(maxlen,end-start);
               while(map.containsKey(c) && start<end) {
                   Character c1 = s.charAt(start);
                   map.put(c1,map.get(c1)-1);
                   if(map.get(c1)==0){
                       map.remove(c1);
                   }
                   start++;
               }
            }
            map.put(c,map.getOrDefault(c,0)+1);
            end ++;
        }
        maxlen=Math.max(maxlen,end-start);
    return maxlen;
    }

}
