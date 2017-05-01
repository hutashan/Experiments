package ThreadDemo;

public class DeadLockDemo {

    public static void main(String arg[]) {
        Object ob1 = new Object();
        Object ob2 = new Object();
        Object ob3 = new Object();
        Thread t1 = new Thread(new SyncThread(ob1, ob2), "t1");
        Thread t2 = new Thread(new SyncThread(ob2, ob3), "t2");
        Thread t3 = new Thread(new SyncThread(ob3, ob1), "t3");

        try {
            t1.start();
            Thread.sleep(5000);
            t2.start();
            Thread.sleep(5000);
            t3.start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


