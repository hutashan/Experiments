package ThreadDemo;

public class MySyn {

    public static void main(String a[]){
        Table table = new Table();
        Table table1 = new Table();
        MyThread1 t1 = new MyThread1(table);
        MyThread2 t2 = new MyThread2(table);
        MyThread1 t12 = new MyThread1(table1);
        MyThread2 t22 = new MyThread2(table1);
        t1.start();
        t2.start();
        t12.start();
        t22.start();
    }
}
