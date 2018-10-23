package G.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String arg[]){
        int [] n1 = {6};
        int [] n2 = {9, 8, 7, 3, 2, 1, 6};
        new NextGreaterElementI().nextGreaterElement(n1,n2);

    }
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

    public NextGreaterElementI() {
    }
}
