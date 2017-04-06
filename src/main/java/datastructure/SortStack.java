package datastructure;

import java.util.Stack;

public class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> input){
        Stack<Integer> tmpSt = new Stack<Integer>();
        while (!input.isEmpty()){
            int tmp = input.pop();
            while (!tmpSt.isEmpty() && tmpSt.peek()<tmp){
                input.push(tmpSt.pop());

            }
            tmpSt.push(tmp);
        }
        return tmpSt;
    }

    public static void main(String a[]){
       Stack<Integer> st = new Stack<Integer>();
        st.push(12);
        st.push(2);
        st.push(7);
        st.push(8);st.push(5);st.push(10);st.push(3);st.push(1);
        Stack<Integer> st1 = sortStack(st);
        while(!st1.isEmpty())
            System.out.println(st1.pop());
        }


    }

