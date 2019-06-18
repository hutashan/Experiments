package TopQ;
import java.util.*;

public class FirstUniqChar {

    public static void main(String[] args) {


        System.out.println(new FirstUniqChar().strStr("hello","ll"));
    }

    public int firstUniqChar(String s) {
        int result = s.length();
        for(char c='a'; c<='z';c++){
            int index = s.indexOf(c);
            int temp = s.lastIndexOf(c);
            if(index!=-1 && index==s.lastIndexOf(c)){
                result = Math.min(result,index);
            }
        }
        return result==s.length()?-1:result;
    }
    public int firstUniqChar1(String s) {
        Map <Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            Character curr = s.charAt(i);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        for(int i=0;i<s.length();i++){
            Character curr = s.charAt(i);
            if(map.get(curr)==0) return i;
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

}
