package simpleprob;

/**
 * Created by parmana on 2/1/17.
 */
public class Fibonacci {

    public static void main(String[] args) {
        for (int i=0;i<=10;i++)
            System.out.print(fn(i)+" ");
    }
    public static long fn(long n){
        if(n<=1)
            return n;
            else
            return fn(n-1)+fn(n-2);
    }
}
