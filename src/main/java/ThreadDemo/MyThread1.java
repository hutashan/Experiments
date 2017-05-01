package ThreadDemo;


public class MyThread1 extends Thread {
    Table t1;
    MyThread1(Table t){
        t1 =t;
    }
    public void run(){
        t1.printTable(100);
    }
}
