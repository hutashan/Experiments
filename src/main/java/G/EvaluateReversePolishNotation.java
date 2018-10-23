package G;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String arg[]){
        String[] c = {"2", "1", "+", "3", "*"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(c));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> sc = new Stack<>();
    for(int i=0;i<tokens.length;i++){
       if(tokens[i].equals("+")){
           int result = sc.pop()+sc.pop();
           sc.push(result);
       } else if(tokens[i].equals("-")){
           int result = sc.pop()-sc.pop();
           sc.push(result);
       } else if(tokens[i].equals("*")){
            int result = sc.pop()*sc.pop();
            sc.push(result);
        } else if(tokens[i].equals("/")){
            int result = sc.pop()/sc.pop();
            sc.push(result);
        } else{
           sc.push(Integer.parseInt(tokens[i]));
       }

    }
    return sc.pop();
    }
}
