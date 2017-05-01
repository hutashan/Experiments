package ThreadDemo;

public class TestWait {
    public static void main(String a[]){
        final Customer c=new Customer();
        new Thread(){
            public void run(){c.withDrawl(15000);}
        }.start();
        new Thread(){
            public void run(){c.deposit(10000);}
        }.start();
    }
}
