package G;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;
public class NextClosestTime {

    public static void main(String[] arg){
        String time = "19:34";  // 12:34
        System.out.println('2'=='2'?'3':'9');
        System.out.println(new NextClosestTime().nextClosestTime(time));
    }

    public String nextClosestTime1(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        Set<Integer> allowed = new HashSet();
        for (char c: time.toCharArray()) if (c != ':') {
            allowed.add(c - '0');
        }

        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            search : {
                for (int d: digits) if (!allowed.contains(d)) break search;
                return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
    }
    public String nextClosestTime(String time) {
        char[] nums = new char[4];
        nums[0]=time.charAt(4);
        nums[1]=time.charAt(3);
        nums[2]=time.charAt(1);
        nums[3]=time.charAt(0);
        Arrays.sort(nums);


        char[] res = time.toCharArray();
        // set HH:M_
        res[4] = getNext(nums, res[4], '9');
        if (res[4]>time.charAt(4)) return new String(res);

        // set HH:_M
        res[3] = getNext(nums, res[3], '5');
        if (res[3]>time.charAt(3)) return new String(res);

        // set H_:MM
        res[1] = getNext(nums, res[1], res[0]=='2'?'3':'9');
        if (res[1]>time.charAt(1)) return new String(res);

        // set _H:MM
        res[0] = getNext(nums, res[0], '2');
        return new String(res);
    }

    private char getNext(char[] nums, char cur, char upperBound) {
        if (cur<upperBound) {
            for (int i=0; i<nums.length&&nums[i]<=upperBound; ++i) {
                if (nums[i]>cur)
                    return nums[i];
            }
        }

        return nums[0];
    }


}

