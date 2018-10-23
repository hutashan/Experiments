package M;
import java.util.*;
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("VI"));
    }
    public int romanToInt(String s) {
        Queue<Integer> q = new LinkedList();
        for(int i = s.length() - 1; i >= 0; i--) {
            char next = s.charAt(i);
            int nextInt = getInt(next);
            q.add(nextInt);
        }

        int previous = 0;
        int sum = 0;
        while(q.peek() != null) {
            int current = q.poll();
            if(current < previous) {
                current *= -1;
            }
            previous = Math.abs(current);
            sum += current;
        }
        return sum;
    }

    private int getInt(char roman) {
        switch(roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
