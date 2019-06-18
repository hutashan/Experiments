package ad;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abccdde"));
    }
    public int lengthOfLongestSubstring(String s) {
        int[] a = new int[256];
        int max = 0;
        int rep = 0;
        for (int i = 1; i <= s.length(); ++i) {
            int c = s.charAt(i - 1);
            rep = Math.max(rep, a[c]);
            int count = i - rep;
            if (count > max)
                max = count;
            a[c] = i;
        }
        return max;
    }
}
