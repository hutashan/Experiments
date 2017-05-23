package simpleprob;

import java.util.Stack;

/**
 * Created by parmana on 4/7/17.
 */
public class Calculator_N {


    public static void main(String[] args) {

        String s= "2+3*3";
        Stack<Character> st= new Stack<Character>();
        boolean pop=false;
        int operation=0;
         char aa[] =s.toCharArray();


        for(char a:aa){
         if(pop){
             int val=0;
            char sg= st.pop();
             if(operation==1){
                  val= Integer.parseInt(a+"")*Integer.parseInt(sg+"");
             } else {
                  val= Integer.parseInt(sg+"")/Integer.parseInt(a+"");
             }

             pop=false;

         } else {


         }




        }




    }
}
