package G;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String arg[]){
        List<Interval> ls = new ArrayList<Interval>();
        Interval in = new Interval(1,2);
        ls.add(in);
        in = new Interval(2,6);
        ls.add(in);
        in = new Interval(7,10);
        ls.add(in);
        in = new Interval(11,13);
        ls.add(in);
        in = new Interval(14,16);
        ls.add(in);
        List<Interval> ls1 = new MergeIntervals().merge(ls);
        for(Interval l : ls1){
            System.out.println(l.start+","+l.end);
        }
    }


    public List<Interval> merge(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }



    public List<Interval> merge1(List<Interval> intervals) {
        List <Interval> ls = new ArrayList<Interval>();

        Interval inter=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval next = intervals.get(i);
            if(inter.end>=next.start){
                inter.end=next.end;
            }else{
                ls.add(inter);
              //  ls.add(next);
                inter=next;

            }

        }
        ls.add(inter);
    return ls;
    }
}
