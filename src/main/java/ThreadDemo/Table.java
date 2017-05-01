package ThreadDemo;

import java.util.concurrent.SynchronousQueue;

public class Table {
    synchronized static void printTable(int n){
         {
             for (int i = 1; i <= 10; i++) {
                 System.out.println(n * i);
             }
         }
    }

}
