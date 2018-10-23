package G;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String arg []){
        List<Interval> ls = new ArrayList<Interval>();
        Interval in = new Interval(1,2);
        ls.add(in);
        in = new Interval(3,5);
        ls.add(in);
        in = new Interval(6,7);
        ls.add(in);
        in = new Interval(8,10);
        ls.add(in);
        in = new Interval(12,16);
        ls.add(in);
        List<Interval> ls1 = new InsertInterval().insert(ls,new Interval(4,8));
        for(Interval l : ls1){
            System.out.println(l.start+","+l.end);
        }


    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start)
                result.add(i);
            else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }



    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        List <Interval> ls12 = new ArrayList <Interval>();
        Interval n = null;
        int i=0;

        while (i<intervals.size()){
            Interval interval  = intervals.get(i);

            n  = new Interval(interval.start, interval.end);

            if(interval.start<newInterval.end && interval.start<newInterval.start && interval.end > newInterval.start ){

              if(interval.end <newInterval.end && (i+1<intervals.size() && intervals.get(i+1).start>=newInterval.end || i+1>intervals.size() )) {
                  n.end = newInterval.end;
              } else{
                  i++;
                  while(i<intervals.size() && interval.end >newInterval.end  && newInterval.end <interval.start ){
                      i++;
                      interval  = intervals.get(i);
                  }
                  n.end = newInterval.end;


              }

            }

            ls12.add(n);
            i++;
        }
        return ls12;
    }
}
