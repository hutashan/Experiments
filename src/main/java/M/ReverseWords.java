package M;

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        String  input = "  a  b";
        System.out.println(new ReverseWords().reverseWords(input));

    }
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return "";
        Stack<String> st = new Stack<String>();
        String [] arr = s.trim().split(" ");
        for(int i=0;i<arr.length;i++){
            if(arr[i].trim().length()!=0) {
                st.push(arr[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
            if(!st.isEmpty()){
                sb.append(" ");
            }

        }
        return sb.toString();


    }

}
