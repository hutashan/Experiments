package F;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FindAnagrams {

    public static void main(String[]args){
        String  s= "abab";
        String p= "ab";
        FindAnagrams fA = new FindAnagrams();
        List<Integer> ls = fA.findAnagrams(s,p);
        for(int l : ls){
            System.out.println(l);
        }
    }


    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        char [] sar = p.toCharArray();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(sar);
        String sortedP = new String(sar);
        for(int i=0;i<s.length();i++){
            if(sortedP.contains(s.charAt(i)+"")){
                if(i+len<=s.length()) {
                    String candidate = s.substring(i, i + len);
                    char [] sCand = candidate.toCharArray();
                    Arrays.sort(sCand);
                    String newCan = new String (sCand);
                    if(newCan.equals(sortedP))
                        ls.add(i);
                  //  break;
                }

            }

        }
        return ls;
    }

}
