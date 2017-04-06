package datastructure;


import java.util.Stack;

public class MyQue {
   Stack<Integer> oldSt,newSt;

    public MyQue(){
        oldSt=new Stack<Integer>();
        newSt=new Stack<Integer>();
    }

    public int size(){
        return oldSt.size()+newSt.size();
    }
    public void shiftNew(){
        if (newSt.isEmpty()) {

            while (!oldSt.isEmpty()) {
                newSt.push(oldSt.pop());
            }
        }

    }
    public int peek(){
        shiftNew();
        return newSt.peek();
    }

    public int pop(){
        shiftNew();
        return newSt.pop();
    }

    public void push(int v){
        oldSt.push(v);
    }


    public static void main(String a[]){
        MyQue cl = new MyQue();
        cl.push(1);
        cl.push(2);
        cl.push(3);
        cl.push(4);
        System.out.println(cl.pop());
        System.out.println(cl.pop());
    }



}
