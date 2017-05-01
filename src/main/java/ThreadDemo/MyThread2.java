package ThreadDemo;

public class MyThread2 extends Thread {
    Table t1;
    MyThread2(Table t){
        t1 =t;
    }
    public void run(){
        t1.printTable(5);
    }
}
