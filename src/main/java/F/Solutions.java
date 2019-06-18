package F;

import java.util.LinkedList;
import java.util.Queue;

class Solutions {
    public static void main(String[] args) {
        System.out.println(new Solutions().romanToInt("LVIII"));
    }
    public int getInt (char c){
        int n=0;
        if(c == 'I') n=1;
        if(c=='V') n=5;
        if(c=='X') n=10;
        if(c=='L') n=50;
        if(c=='C') n=100;
        if(c=='D') n = 500;
        if(c=='M') n =1000;
        return n;
    }
    public int romanToInt(String s) {

        Queue<Integer> q = new LinkedList();
        for(int i = s.length() - 1; i >= 0; i--) {
            char next = s.charAt(i);
            int nextInt = getInt(next);
            q.add(nextInt);
        }
        int result =0;
        int current  =0;
        int previous = 0;

        while(q.peek() != null) {

            current = q.poll();
            if(current < previous) {
                current *= -1;
            }
            previous = Math.abs(current);
            result += current;


        }
        return result;
    }
}
