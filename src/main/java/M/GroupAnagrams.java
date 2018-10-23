package M;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new GroupAnagrams().groupAnagrams(input);
        for (List<String> s : res) {
            for (String st : s) {
                System.out.print(st);
            }
            System.out.println();
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null) return null;
        HashMap<String,List<String>> hs = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String newStr = getSorted(strs[i]);
            if(hs.containsKey(newStr)){
                List<String>  ls =  hs.get(newStr);
                ls.add(strs[i]);
                hs.put(newStr,ls);
            }else {
                List<String>  ls =  new ArrayList<>();
                ls.add(strs[i]);
                hs.put(newStr,ls);
            }

        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String,List<String>>  enty : hs.entrySet()){
            res.add(enty.getValue());
        }
        return res;
    }
    private String getSorted(String st) {
        char [] arr = st.toCharArray();
        Arrays.sort(arr);
        String newStr = new String (arr);
        return newStr;
    }
}
