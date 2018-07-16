package G;

import java.util.HashSet;

public class LengthOfLongestSubstringKDistinct {
    public static void main(String arg[]) {
        String input = "bacc";
        System.out.println(new LengthOfLongestSubstringKDistinct().lengthOfLongestSubstringKDistinct(input, 2));


    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        if (s == null) return 0;

        if (s.length() == 0) {
            return 0;
        }



        int maxCount = 0;
        int leftIndex = 0;
        int origK = k;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (sb.toString().contains(s.charAt(i) + "")) {
                sb.append(s.charAt(i));
            } else {
                if (k == 0) {
                    maxCount = Math.max(maxCount, sb.length());
                    k = origK;
                    sb = new StringBuffer();
                    i=i-k;
                } else {
                    k--;
                    sb.append(s.charAt(i));
                }
            }


        }
        return Math.max(maxCount, sb.length());
    }

}
