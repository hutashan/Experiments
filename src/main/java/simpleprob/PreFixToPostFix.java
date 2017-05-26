package simpleprob;

import java.util.List;
import java.util.Stack;

/**
 * Created by parmana on 4/10/17.
 */
public class PreFixToPostFix {


    public static void main(String[] args) {

        //System.out.println(calc(convertPostFix("(2+3)*(4+5)")));
        System.out.println(calc(convertPostFix("2*2+3")));




    }
//*+
// 2*3+3  233+*
    public static List<Character> convertPostFix(String prefix){

        List<Character> l = new java.util.ArrayList<Character> ();
        Stack<Character> st = new Stack<Character>();

        char [] aa= prefix.toCharArray();

         for(char c:aa){

             if(Character.isDigit(c)){
                 l.add(c);
             } else {
                 if (st.empty() ||c=='(') {
                    st.push(c);
                 } else {
                      if(c==')'){
                          l.add(st.pop());
                          st.pop();
                      } else {
                          int current = getPrecedence(c);
                          int prev = getPrecedence(st.peek());
                          if (current == prev) {
                              l.add(st.pop());
                              st.push(c);
                          } else if (current < prev) {
                              l.add(st.pop());
                              st.push(c);
                          } else {
                              st.push(c);
                          }
                      }
                 }
             }

         }

        while (!st.isEmpty()){
            l.add(st.pop());
        }


        System.out.println(l.toString());

        return l;
    }


    public static int getPrecedence(char c){

        if(c=='*'|| c=='/'){
            return 2;
        } else if(c=='+' || c=='-'){
            return 1;
        } else {
            return 0;
        }

    }


    public static long calc(List<Character> l){

        Stack<Integer> st= new Stack<Integer>();

        for(char c:l){

            if(Character.isDigit(c)){
                st.push(Integer.parseInt(c+""));
            } else {

                switch (c){

                    case '+' : {
                        int r= st.pop()+st.pop();
                        st.push(r);
                        break;
                    }
                    case '-' : {
                        int r= st.pop()-st.pop();
                        st.push(r);
                        break;
                    }
                    case '*' : {
                        int r= st.pop()*st.pop();
                        st.push(r);
                        break;
                    }
                }

            }


        }


        return st.peek();
    }

}
