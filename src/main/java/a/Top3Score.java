package a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Top3Score {
    BlockingQueue<DelayObject> DQ= new DelayQueue<DelayObject>();
    PriorityQueue<DelayObject> pr = new PriorityQueue<DelayObject>((x, y) -> y.score - x.score);
    TreeSet<DelayObject> tr = new TreeSet<DelayObject>((x, y) -> y.score - x.score);
    public static void main(String[] args) throws InterruptedException {

        Top3Score t3 = new Top3Score();
        t3.receivedScore("a",100,300);
        t3.receivedScore("b",200,10);
        t3.receivedScore("c",300,1000);
        t3.receivedScore("d",122,500);
        t3.receivedScore("e",50,300);
        t3.receivedScore("f",10000,1);

        System.out.println(t3.DQ);
        ArrayList<DelayObject> re = t3.topK(2);


        for(DelayObject ls : re){
            System.out.println(ls.name +" "+ls.score);
        }
        Thread.sleep(200);
        ArrayList<DelayObject> re1 = t3.topK(2);
        for(DelayObject ls : re1){
            System.out.println(ls.name +" "+ls.score);
        }

    }


    void receivedScore(String userName, int score, long ts) {
        DelayObject del = new DelayObject(userName, ts, score);
        DQ.add(new DelayObject(userName, ts, score));
       // pr.add(del);
        tr.add(del);
    }

    ArrayList<DelayObject> topK(int k) {
        ArrayList<DelayObject> res = new ArrayList<>();
        long delay =(System.currentTimeMillis() );
        System.out.println("delay " + delay);
        System.out.println("peek time " + DQ.peek().time);

        while ((!DQ.isEmpty()) && (DQ.peek().time) < delay) {
           System.out.println("inside loop");
            DelayObject del = DQ.poll();
            System.out.println(del.name);
            tr.remove(del);


        }
        Iterator<DelayObject> itr =  tr.iterator();
        int m = k;
       while(itr.hasNext() && m>0){
            res.add(itr.next());
        m--;
        }


        return res;
    }
}
