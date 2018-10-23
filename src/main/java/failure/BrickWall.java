package failure;

import scala.Int;

import java.util.*;

public class BrickWall {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 2, 1},
                {3, 1, 2},
                {1, 3, 2},
                {2, 4},
                {3, 1, 2},
                {1, 3, 1, 1}};
        List<List<Integer>> wall = new ArrayList();
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(1);
        ls.add(2);
        ls.add(2);
        ls.add(1);
        wall.add(ls);
        List<Integer> ls1 = new ArrayList<Integer>();
        ls1.add(3);
        ls1.add(1);
        ls1.add(2);
        wall.add(ls1);
        List<Integer> ls2 = new ArrayList<Integer>();
        ls2.add(2);
        ls2.add(4);
        wall.add(ls2);
        List<Integer> ls3 = new ArrayList<Integer>();
        ls3.add(3);
        ls3.add(1);
        ls3.add(2);
        wall.add(ls3);
        List<Integer> ls4 = new ArrayList<Integer>();
        ls4.add(1);
        ls4.add(3);
        ls4.add(1);
        ls4.add(1);
        wall.add(ls4);
        System.out.println(new BrickWall().leastBricks(wall));
    }

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> ls = wall.get(i);
            int curr = 0;
            for (int j = 0; j < ls.size(); j++) {
                curr = curr + ls.get(j);

                if (j != 0 && j != ls.size() - 1) {
                    if (!hs.containsKey(curr)) {
                        hs.put(curr, 0);
                    } else {
                        hs.put(curr, hs.get(curr) + 1);
                    }
                }

            }
        }
        int max = 0;

        for (Map.Entry<Integer, Integer> entry : hs.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        if(max==0){
            return wall.size();
        }
      //  System.out.println(max);
        return wall.size() -1 - max;
    }
}