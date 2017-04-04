package datastructure;

import java.io.*;
import java.util.*;

public class Q1 {
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static List<Interval> uncoveredIntervals(List<Interval> intervals) {
        List<Interval> uncovered = new ArrayList<Interval>();
        // Your code here
        TreeMap<Integer,Integer> tr= new TreeMap<Integer,Integer>();
        for(int i=0; i<intervals.size(); i++) {
            tr.put(intervals.get(i).start, intervals.get(i).end);
        }
        int posibleStart=0;
        Set t= tr.keySet();
        Iterator itr= t.iterator();
        while (itr.hasNext()){
            int key= (Integer)itr.next();
            int val = tr.get(key);
            if(posibleStart!=0){
                if(posibleStart>key && posibleStart<val){
                    posibleStart=val;
                }else if(posibleStart>key && posibleStart >= val) {
                    posibleStart=posibleStart;
                } else if(posibleStart<val & posibleStart!=key){
                    uncovered.add (new Interval(posibleStart,key));
                    posibleStart=val;
                }else {
                    posibleStart=val;
                }
            } else {
                posibleStart=val;
            }
        }

        return uncovered;
    }

    /*
     *  Hey! You probably don't need to edit anything below here
     */

    private static List<Interval> readIntervals(InputStream is) throws IOException {
        File file = new File("src/data/input_1.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Interval> intervals = new ArrayList<Interval>();
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            intervals.add(toInterval(line));
        }
        return intervals;
    }

    private static Interval toInterval(String line) {
        final String[] tokenizedInterval = line.split(" ");

        return new Interval(Integer.valueOf(tokenizedInterval[0]),
                            Integer.valueOf(tokenizedInterval[1]));
    }

    public static void main(String... args) throws IOException {
        List<Interval> intervals = Q1.readIntervals(System.in);
        List<Interval> uncovered = Q1.uncoveredIntervals(intervals);
        for (Interval i : uncovered) {
            System.out.println(i.start + " " + i.end);
        }
    }
}
