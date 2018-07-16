package G;

public class Palindrome {
    public static void main (String arg[]){
        String s = ".,";
        System.out.println(new Palindrome().isPalindrome(s));

    }
    public boolean isPalindrome(String s1) {
        if(s1==null || s1.equals("")) return true;

        String s = s1.toLowerCase();
        int start =0;
        int end = s.length()-1;

        while(start<end){
            while(start<end && (!Character.isLetterOrDigit(s.charAt(start)))){
                start++;
            }
            if((start>end)) break;
            while(start<end && (!Character.isLetterOrDigit(s.charAt(end)))){
                end--;
            }

            if((start>end)) break;

            if(s.charAt(start)!= s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

}
