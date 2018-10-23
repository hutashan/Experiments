package M;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static void main(String[] args) {


    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        int count =1;
        Arrays.sort(intervals,(a,b) -> a.start-b.start );
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
        pr.add(intervals[0].end);
        for(int i=0;i<intervals.length;i++){
            if(pr.peek()>intervals[i].start){
                count ++;
            }else{
                pr.poll();
            }
            pr.add(intervals[i].end);
        }
        return count;
    }
}
