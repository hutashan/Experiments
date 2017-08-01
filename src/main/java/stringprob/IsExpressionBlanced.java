package stringprob;

import java.util.Stack;

/**
 * Created by parmana on 8/1/17.
 */
public class IsExpressionBlanced {


    public static void main(String[] args) {

        String exp="{[{}{}]}[()]}";
        System.out.println(isBalanceedExpression(exp));


    }

    public static boolean isBalanceedExpression(String exp){

        Stack<Character> st= new Stack<Character>();
        char c[]=exp.toCharArray();
        for(char ch:c){
            if((ch==')' || ch ==']' ||  ch =='}') && !st.isEmpty() ){
                char c1= st.pop();

                if((c1=='(' && ch==')')
                        || (c1=='[' && ch==']')
                        || (c1=='{' && ch=='}')){

                } else {
                    return false;
                }


            } else {
                st.push(ch);
            }

        }

        if(st.empty())
            return true;



        return false;
    }


}
