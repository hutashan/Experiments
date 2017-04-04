package datastructure;


import javax.swing.text.html.parser.Parser;
import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {

   static Stack<Integer> minSc = new  Stack<Integer>();
    public static void main(String arg[]){
        StackWithMin2 s = new StackWithMin2();
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(2);
        System.out.println("min"+ s.minVal());
        System.out.println( s.pop1());
        System.out.println("min"+ s.minVal());
        System.out.println( s.pop1());
        System.out.println("min" + s.minVal());

    }
    public  void push(int val){
        if(minSc.empty() || minSc.peek()>val){
            minSc.push(val);
        }
        super.push(val);
    }
    public  int pop1 (){
        int valPop= super.pop();
        if(minSc.peek()==valPop){
            minSc.pop();
        }
        return valPop;
    }

    public int peek1(){
        return super.peek();
    }

    public int minVal(){
       return minSc.peek();
    }

}
