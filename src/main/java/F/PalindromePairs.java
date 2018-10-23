package F;

import java.util.*;

public class PalindromePairs {
    public static void main(String[] args) {
        String [] input ={"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> res = new PalindromePairs().palindromePairs(input);
       for(int i=0;i<res.size();i++){
           for(int j=0;j<res.get(i).size();j++){
               System.out.print(res.get(i).get(j) +" ,");
           }
           System.out.println();
       }
    }


// best Approach using tries // Start

    class Node{
        Node[] next;
        int index;
        List<Integer> list;
        Node(){
            next=new Node[26];
            index=-1;
            list=new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Node root=new Node();
        List<List<Integer>> res=new ArrayList();
        for(int i=0;i<words.length;i++) addnode(words[i],i,root);
        for(int i=0;i<words.length;i++) searchnode(words[i],i,root,res);
        return res;
    }
    private void addnode(String word,int idx,Node root){
        for(int i=word.length()-1;i>=0;i--){
            if(isP(word,0,i)) root.list.add(idx);
            char c=word.charAt(i);
            if(root.next[c-'a']==null) root.next[c-'a']=new Node();
            root=root.next[c-'a'];
        }
        root.index=idx;
        root.list.add(idx);
    }
    private void searchnode(String word,int idx,Node root,List<List<Integer>> res){
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(root.index!=-1 && root.index!=idx && isP(word,i,word.length()-1)) res.add(Arrays.asList(idx,root.index));
            root=root.next[c-'a'];
            if(root==null) return;
        }
        for(int j:root.list){
            if(j==idx) continue;
            res.add(Arrays.asList(idx,j));
        }


    }
    private boolean isP(String word, int i,int j){
        while(i<j){
            if(word.charAt(i++)!=word.charAt(j--)) return false;
        }
        return true;
    }



// best Approach using tries // End





// Better Approach start
    public List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            // System.out.println(words[i]);
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return ret;
    }
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }

// Better Approach  end

    public List<List<Integer>> palindromePairs1(String[] words) {
        if(words==null && words.length==0) return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (isPalimdrome(words[i] + words[j]) && i!=j) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    res.add(ls);
                }
            }


        }
        return res;
    }

    private boolean isPalimdrome(String s){
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
