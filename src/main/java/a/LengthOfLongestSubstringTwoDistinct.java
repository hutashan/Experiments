package a;

import java.util.HashMap;

public class LengthOfLongestSubstringTwoDistinct {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstringTwoDistinct().lengthOfLongestSubstringTwoDistinct("eceba"));
        int [][] chase = {{123},{123}};


    }



    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null || s.length()==0) return 0;
        int max = 1;
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0;
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
           map.put(c,map.getOrDefault(c,0)+1);

           while(map.size()>2){
               Character cLeft = s.charAt(left);
               map.put(cLeft,map.getOrDefault(cLeft,0)-1);
               if(map.get(cLeft)==0) map.remove(cLeft);
               left++;
           }
            if(map.size()==2){
                max = Math.max(max,i-left+1);
            }
        }
        return max;
    }
}
