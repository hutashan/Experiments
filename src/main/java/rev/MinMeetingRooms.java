package rev;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }



    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0]= new Interval(0,30);
        intervals[1]= new Interval(5,10);
        intervals[2]= new Interval(15,20);
        System.out.println(new MinMeetingRooms().minMeetingRooms(intervals) );

    }

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        int len = intervals.length;
        int [] start = new int [len];
        int [] end = new int[len];
        for(int i=0;i<len;i++){
           start[i]=intervals[i].start;
           end[i] = intervals[i].end;

        }
        Arrays.sort(start);
        Arrays.sort(end);
        int delayEnd =0;
        int rooms =0;
        for(int i=0;i<len;i++){
            if(start[i]<end[delayEnd]) rooms++;
            else delayEnd++;

        }
        return rooms;

    }




    public int minMeetingRooms2(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals,(a,b) -> a.start-b.start );
        PriorityQueue<Integer> prQue = new PriorityQueue<>();
        prQue.add(intervals[0].end);
        int count=1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start<prQue.peek()){
                count++;
            } else{
                prQue.poll();

            }
            prQue.add(intervals[i].end);

        }
        return count;
    }

    public int minMeetingRooms1(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        int count =1;
        Arrays.sort(intervals,(a,b) -> a.start-b.start );
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
        pr.add(intervals[0].end);
        for(int i=1;i<intervals.length;i++){
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
