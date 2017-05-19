package ThreadDemo;

import java.util.concurrent.Callable;
public class MyCallable implements Callable<Long> {
    public Long call() throws Exception {
        long sum = 0;
        for (long i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum "+sum);
        return sum;
    }

}
