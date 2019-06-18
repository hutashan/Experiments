package G;

import java.util.PriorityQueue;
import java.util.*;

public class MincostToHireWorkers {
    public static void main(String[] args) {
        int k=2;
        int [] quantity = {3,1,10,10,1};
        int [] wage = {4,8,2,2,7};
        System.out.println(new MincostToHireWorkers().mincostToHireWorkers(quantity,wage,k));

    }
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
}
