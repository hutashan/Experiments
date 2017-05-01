package ThreadDemo;


public class Customer {
    int amount = 1000;
    synchronized void withDrawl(int amt){
        if (amt>amount){
            System.out.println("less balance wait for deposit");
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
            amount = amount-amt;
        }
    }
    synchronized void deposit (int amt){
        System.out.println("going to deposit");
        this.amount = amount + amt;
        System.out.println("deposit completed");
        notifyAll();
    }
}
