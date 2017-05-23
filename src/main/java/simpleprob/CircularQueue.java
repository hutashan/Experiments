package simpleprob;

/**
 * Created by parmana on 4/6/17.
 */
public class CircularQueue {

    public  int capacity;
    public  int f=0;
    public  int r=0;
    public int que[];
    public int size=0;


    public CircularQueue(int capacity){
        this.capacity=capacity;
        que = new int[capacity];
    }


    public  boolean isFull(){

        if(size==capacity){
            return  true;
        } else
            return false;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        } else
            return false;

    }

    public  void  enque(int val){
         if(isFull()){
             System.out.println("queue is full");
             return;
         }else{
             que[r]=val;
            r=(r+1)%capacity;
            size++;
         }
    }

    public int dque(){

        if(isEmpty()){
            System.out.println("queue is empty");
            return 0;
        } else {
            int val = que[f];
            que[f]=0;
            f= (f+1)%capacity;
            size--;
            return val;
        }


    }



    public static void main(String[] args) {

        CircularQueue obj = new CircularQueue(3);
        obj.enque(12);
        obj.enque(13);
        obj.enque(14);
        obj.enque(15);
        for(int a:obj.que){
            System.out.println(a);
        }
        obj.dque();
        obj.dque();
        obj.enque(19);
        System.out.println("-----");
        for(int a:obj.que){
            System.out.println(a);
        }

    }

}
