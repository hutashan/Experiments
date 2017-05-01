package arr;

public class CircularArray {

    int[] circular ;
    int N;
    int f, r,size =0;
    public CircularArray(int n){
        N = n;
        circular = new int[N];
    }
    public boolean isFull(){
        int diff = r-f;
        if ((size == N)){
             return true;
        } else
            return false;
    }

  /*  public int size (){

        if(r>f){
            return r-f;
        } else{
            return N - r +f;
        }
    } */



    public boolean isEmpty(){
        if ((r==f)&& (size!=N)){
            return true;
        } else
            return false;
    }
    public void enque(int element) throws Exception {
        if (isFull()){
            throw new Exception("Full");
        }
        circular[r]=element;
        r = (r+1)%N;
        size ++;

    }
    public int deque() throws Exception{
        if(isEmpty()){
            throw new Exception("empty");
        }
       int element = circular[f];
        f = (f+1)%N;
        size --;
        return element;
    }
    public static void main(String arg[]){
        CircularArray cir = new CircularArray(4);
        try {
            cir.enque(1);
            cir.enque(2);
            cir.enque(3);
            cir.enque(4);
            //cir.enque(5);
            cir.deque();
            cir.deque();
            cir.deque();
            cir.deque();
            cir.enque(5);
            cir.deque();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
