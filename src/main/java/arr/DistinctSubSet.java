package arr;


import scala.Char;
import scala.collection.mutable.Stack;

public class DistinctSubSet {
    public static void main(String[] arg){
        int[] c = {1,2,3};

        findPowerSet(c, new Stack<Integer>(),2 );

    }
    static void findPowerSet(int[] s, Stack<Integer> stack, int i){
        if (i<=0){
            System.out.println(stack.toString());
            return;
        }
        stack.push(s[i]);
        findPowerSet(s,stack,i-1);
        stack.pop();
        while(s[i]==s[i-1]){
        i--;
        }
        findPowerSet(s,stack,i-1);
    }
    static  void printStack(Stack<Integer> sc){
        for (int i=0;i<sc.length();i++){
            System.out.println(sc.pop());
        }
    }

}
