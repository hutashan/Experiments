package G;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String arg[]){
        String s ="]";
        System.out.println(new ValidParentheses().isValid(s));

    }
    public boolean isValid(String s) {
        Stack <Character> st = new Stack<Character>();

        for(int i=0;i<s.length();i++){

         if(s.charAt(i)=='}' && st.size()!=0 && st.peek()=='{'){
             st.pop();
         } else if(s.charAt(i)==']' && st.size()!=0 && st.peek()=='['){
                st.pop();
        } else if(s.charAt(i)==')' && st.size()!=0 && st.peek()=='('){
                st.pop();
         } else{
             st.push(s.charAt(i));
         }

        }

        return st.size()==0;

    }
}
