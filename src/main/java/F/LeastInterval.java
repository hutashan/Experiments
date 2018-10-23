package F;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeastInterval {
    public static void main(String[] args) {
        char[] input = {'A','A','A','B','B','B','C','C'};
        System.out.println(new LeastInterval().leastInterval(input,2));
    }
    public int leastInterval(char[] tasks, int n) {
        int[] storage = new int[26];
        for (char c : tasks) {
            storage[(c - 'A')]++;
        }
        int max = 0;
        int count = 1;
        for (int num : storage) {
            if (num == 0) {
                continue;
            }
            if (max < num) {
                max = num;
                count = 1;
            } else if (max == num) {
                count++;
            }
        }
        int space = (n + 1) * (max - 1) + count;
        return (space < tasks.length) ? tasks.length : space;
    }
}
