package hardprob;
/**
 * leetcode 773. Sliding Puzzle
 */

import java.util.*;

public class SlidingPuzzle {
    public static void main(String arg[]) {
        SlidingPuzzle sObj = new SlidingPuzzle();
        int[][] arr = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(sObj.sildingPuz(arr));
    }


    public int sildingPuz(int[][] board) {
        Set seen = new HashSet<String>();
        String s = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");
        Queue<String> q = new LinkedList((Arrays.asList(s)));
        int[] potentionMove = {1, -1, 3, -3};
        String target = "123450";
        int count = 0;
        while (!q.isEmpty()) {
            for (int sz = q.size(); sz > 0; --sz) {
                String str = q.poll();
                if (str.equals(target)) {
                    return count;
                }
                int idx = str.indexOf("0");
                for (int i = 0; i < potentionMove.length; i++) {
                    int newMove = idx + potentionMove[i];
                    if (newMove < 0 || newMove > 5 || idx == 2 && newMove == 3 || idx == 3 && newMove == 2) {
                        continue;
                    }
                    char[] ch = str.toCharArray();
                    char temp = ch[newMove];
                    ch[newMove] = ch[idx];
                    ch[idx] = temp;
                    s = String.valueOf(ch);
                    if (seen.add(s)) {
                        q.offer(s);
                    }

                }
            }
            ++count;
        }
        return -1;
    }


    public int slidingPuzzle(int[][] board) {
        Set<String> seen = new HashSet<>(); // used to avoid duplicates
        String target = "123450";
        // convert board to string - initial state.
        String s = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");
        Queue<String> q = new LinkedList<>(Arrays.asList(s));
        seen.add(s); // add initial state to set.
        int ans = 0; // record the # of rounds of Breadth Search
        while (!q.isEmpty()) { // Not traverse all states yet?
            // loop used to control search breadth.
            for (int sz = q.size(); sz > 0; --sz) {
                String str = q.poll();
                if (str.equals(target)) {
                    return ans;
                } // found target.
                int i = str.indexOf('0'); // locate '0'
                int[] d = {1, -1, 3, -3}; // potential swap displacements.
                for (int k = 0; k < 4; ++k) { // traverse all options.
                    int j = i + d[k]; // potential swap index.
                    // conditional used to avoid invalid swaps.
                    if (j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j == 2) {
                        continue;
                    }
                    char[] ch = str.toCharArray();
                    // swap ch[i] and ch[j].
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                    s = String.valueOf(ch); // a new candidate state.
                    if (seen.add(s)) {
                        q.offer(s);
                    } //Avoid duplicate.
                }
            }
            ++ans; // finished a round of Breadth Search, plus 1.
        }
        return -1;
    }
}
