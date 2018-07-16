package G;

public class ShortestPalindrome {
    public static void main(String arg[]){
        String s ="abcd";
        System.out.println(new ShortestPalindrome().shortestPalindrome(s));

    }
    public String shortestPalindrome(String s) {
        int j=0;
        for(int i=s.length()-1;i>=0 && j<s.length() ;i--){
            char ia = s.charAt(i);
            char ja = s.charAt(j);
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }

        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
       return new StringBuffer(suffix).reverse().toString()+shortestPalindrome(s.substring(0,j))+suffix;

    }
}
