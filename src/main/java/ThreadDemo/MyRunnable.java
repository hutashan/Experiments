package ThreadDemo;

/**
 * Created by v708178 on 4/30/17.
 */
public class MyRunnable implements Runnable {
    long counter;

    public MyRunnable(long c){
        this.counter=c;
    }

    public void run() {
        long sum=0;
        for (int i=0;i<counter;i++){
            sum +=i;
        }
        System.out.println("sum"+sum);
    }
}
