package a;

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
    char [] input ={'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        new ReverseWords().reverseWords(input);

    }
    public void reverseWords(char[] str) {
        char[] st1 = new char[str.length]  ;
        Stack <Character> stack = new Stack<>();
        int j=0;
        for(int i=0;i<str.length-1;i++){
            if(str[i]==' '){
                for(;j>=0;j--)
                stack.push(st1[j]);
            } else{
                st1[j]=str[i];
                j++;
            }
        }


    }

}
