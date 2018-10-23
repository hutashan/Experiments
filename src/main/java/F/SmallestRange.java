package F;

import java.util.*;

public class SmallestRange {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(4);
        arr.add(10);
        arr.add(15);
        arr.add(24);
        arr.add(26);
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(0);
        arr2.add(9);
        arr2.add(12);
        arr2.add(20);
        List<Integer> arr3 = new ArrayList<Integer>();
        arr3.add(5);
        arr3.add(18);
        arr3.add(22);
        arr3.add(30);
        List<List<Integer>> arr4 = new ArrayList<List<Integer>>();
        arr4.add(arr);
        arr4.add(arr2);
        arr4.add(arr3);
        SmallestRange a = new SmallestRange();
        int[] ad = a.smallestRange(arr4);
        for (int a2 : ad) {
            System.out.println(a2);
        }


    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.size()) {

            Element curr = pq.poll();
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums.get(curr.row).size()) {
                curr.idx = curr.idx + 1;
                curr.val = nums.get(curr.row).get(curr.idx);
                pq.offer(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[]{start, end};
    }

    class Element {
        int val;
        int idx;
        int row;

        public Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }
}
