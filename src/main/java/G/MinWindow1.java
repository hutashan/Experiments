package G;

import java.util.HashMap;

public class MinWindow1 {
        public static void main(String arg[]) {
            String s = "ADOBECBAODEBANC", t = "ABC";
            System.out.println(new MinWindow().minWindow(s, t));
        }


    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        String result = "";

        HashMap <Character,Integer> target = new HashMap <Character,Integer>();
        HashMap <Character,Integer> map = new HashMap <Character,Integer>();
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(target.containsKey(c)){
                target.put(c,target.get(c)+1);
            } else
                target.put(c,1);
        }

        int left =0;
        int count =0;
        int minLen =s.length()+1;

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(target.containsKey(c)){
                if(map.containsKey(c)){
                    map.put(c,target.get(c)+1);
                    count++;
                } else
                    map.put(c,1);
                  count++;
            }
            if(count==t.length()){
                char st = s.charAt(left);
                if(!map.containsKey(st) || map.containsKey(st) && map.get(st)>target.get(st)){
                    map.put(st, map.get(st) - 1);
                }
                left++;
                st =s.charAt(left);


                if (i - left + 1 < minLen) {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }









        }

        return result;

    }

}
