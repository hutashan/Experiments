package datastructure;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStack {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity ;
    public SetOfStack(int capacity){
        this.capacity = capacity;
    }
    public Stack getLastStack() {
        if (stacks.size() == 0) {
            Stack st = new Stack();
            stacks.add(st);
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push (int val){
    Stack last = getLastStack();
        if(last.isEmpty()|| (!isFull(last))){
            last.push(val);
        } else{
            Stack st = new Stack();
            st.push(val);
            stacks.add(st);
        }
   }


    public boolean isFull(Stack st){
        if (st.size()<capacity){
            return false;
        } else {
            return true;
        }

    }

    public int pop(){
        Stack last = getLastStack();
        int val=  Integer.parseInt(last.pop().toString());
        if(last.size()==0){
            stacks.remove(stacks.size()-1);
        }
        return val;
    }

    public boolean isEmpty(){
        Stack last = getLastStack();
        return(last.isEmpty() || (last==null));
    }


    public int leftShift(int index,boolean removeFromBottom){
        Stack last = stacks.get(index);
        int v ;
        if (removeFromBottom ==false){
            v = Integer.parseInt(last.pop().toString());
        } else {
            v = Integer.parseInt(last.remove(last.size()-1).toString());
        }
        if (last.isEmpty()){
            stacks.remove(index);

        } else{
            if (stacks.size()> index+1){
                int va = leftShift(index+1,false);
                last.push(v);
            }
        }
        return v;
    }

    public int popAt(int index){
        return leftShift(index,true);
    }


    public static void main (String arg[]){
        SetOfStack sOfSt = new SetOfStack(2);
        sOfSt.push(1);
        sOfSt.push(2);
        sOfSt.push(3);
        sOfSt.push(4);
        sOfSt.push(5);
        sOfSt.push(6);

        System.out.println("sOfSt.pop(); " + sOfSt.pop());
        System.out.println("popAt " + sOfSt.popAt(2));

    }
}
