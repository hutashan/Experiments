package F;
//Rev

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.*;

public class RemoveInvalidParentheses {
    List<String> ls = new ArrayList<>();
    static List<String> ls1 = new ArrayList<>();
    Set<String> set = new HashSet<>();
    int max =0;
    public static void main(String[] args) {
        String st = "()())()";
        RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
        List<String> res = obj.removeInvalidParentheses(st);
        for(String s : res){
            System.out.println(s);
        }
    }

    public List<String> removeInvalidParentheses(String st) {
        List<String> res = new ArrayList<>();
        if(st==null) return res;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(st);
        visited.add(st);
        boolean found = false;
        while(!queue.isEmpty()){
            String s = queue.poll();
            if(isValid(s)){
                res.add(s);
                found = true;

            }
            if (found) continue;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('||s.charAt(i)==')') {
                    String newStr = s.substring(0, i) + s.substring(i + 1, s.length());
                    if(!visited.contains(newStr)) {
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }

        }
        return res;

    }













    public List<String> removeInvalidParentheses1(String s) {
        removeInvalidParenthesesRes(s);
        for(String s1 : set){
            ls.add(s1);
        }

        return ls;

    }

    public void removeInvalidParenthesesRes(String s) {
        if(isValid(s)) {
            if(s.length()!=0)
                if(max<s.length()) {
                    set = new HashSet<>();
                    set.add(s);
                    max=s.length();
                }else if(max==s.length()) {
                    set.add(s);
                }
            return;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)==')') {
                String newStr = s.substring(0, i) + s.substring(i + 1, s.length());
                removeInvalidParenthesesRes(newStr);
            }
        }

    }
    public boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }else{
                if(s.charAt(i)==')') {
                    if (st.size() == 0) {
                        return false;
                    }
                    st.pop();
                }
            }
        }
        return(st.size()==0);
    }


}
