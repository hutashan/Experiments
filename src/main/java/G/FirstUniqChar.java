package G;

import java.util.HashMap;
import java.util.HashSet;

public class FirstUniqChar {
    public static void main(String arg[]){
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));
    }
    public int firstUniqChar(String s) {
        int index =-1;
        if(s==null) return index;
        HashMap<String,Integer> mp = new HashMap<String,Integer>();
        boolean[] po = new boolean[s.length()];
        for (int i=0;i<s.length();i++){
            String v = s.charAt(i)+"";
            if(mp.containsKey(v)){
                po[i]=true;
                po[mp.get(v)]=true;
            }
            mp.put(v,i);
        }

        for(int i=0;i<po.length;i++){
            if(!po[i]){
                index =i;
                break;
            };
        }
        return index;
    }
}
