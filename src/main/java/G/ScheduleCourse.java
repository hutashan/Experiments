package G;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ScheduleCourse {
    public static void main(String[] args) {
        int [] [] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
       // int [] [] courses = {{100,2},{32,50}};
        System.out.println(new ScheduleCourse().scheduleCourse(courses));
    }

    public int scheduleCourse(int[][] courses) {
        if(courses==null || courses.length==0) return 0;
        Arrays.sort(courses,((x,y) -> x[1]-y[1]));
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>((x,y) -> y-x);
        int sum=0;
        for(int [] course : courses){

           if( sum +course[0]<= course[1]) {
               sum +=course[0];
               pr.add(course[0]);
           } else{
               if(!pr.isEmpty() && pr.peek()>course[0]){
                   sum +=course[0]-pr.poll();
                   pr.add(course[0]);
               }
           }
        }
        return pr.size();
    }
}
