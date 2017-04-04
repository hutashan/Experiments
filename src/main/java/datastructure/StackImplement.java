package datastructure;

public class StackImplement {

    static int  stackSize = 10;
    static int [] buffer = new int [stackSize*3];
    static  int [] pointer = {0,0,0};

    public static void main(String arg[]){
        try {
            push(1, 1);
            push(1, 2);
            push(1, 3);
            push(1, 4);
            push(1, 5);
            push(2, 12);
            push(2, 22);
            push(2, 32);
            push(2, 42);
            push(2, 52);
            push(3, 13);
            push(3, 23);
            push(3, 33);
            push(3, 43);
            push(3, 53);

            System.out.println(peek(3));
            System.out.println(pop(3));
            System.out.println(peek(3));
            System.out.println(pop(1));
            System.out.println(pop(1));
            System.out.println(peek(1));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   public static void  push(int stackNum,int val) throws Exception {
        if (pointer[stackNum-1]+1> stackSize){
            System.out.printf("reached max");
            throw new Exception("Reached max");
        } else{
            pointer[stackNum-1] = pointer[stackNum-1]+1;
            buffer[getIndex(stackNum)] = val;
        }
    }
   public static int getIndex (int stackNum){
       int indexVal = ((stackNum-1) * stackSize + pointer[stackNum-1]);
  //     System.out.println("index size" + indexVal);
      return indexVal;
    }

   public static int pop(int stackNum) throws Exception {
       if (pointer[stackNum-1] == 0){
           throw new Exception("empty size");
       }
       int val = buffer[getIndex(stackNum)];
       pointer[stackNum-1] = pointer[stackNum-1]-1;
       return val;
   }

    public static boolean isEmpty(int stackNum){
        if (pointer[stackNum-1] == -1){
            return true;
        }
        return false;
    }

    public static int peek(int stackNum){
        return buffer[getIndex(stackNum)];
    }

}
