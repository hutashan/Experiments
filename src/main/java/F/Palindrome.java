package F;

public class Palindrome {
    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(new Palindrome().validPalindrome     (s));

    }
    public boolean isPalindrome(String s1) {
    int l=0,h=s1.length()-1;
    while(l<h){


        while(l<h && !Character.isLetterOrDigit(s1.charAt(l)) && l<s1.length()){
            l++;
        }
        if((l>h)) break;
        while(l<h && !Character.isLetterOrDigit(s1.charAt(h)) && h>=0){
            h--;
        }
        if((l>h)) break;
        if(! (Character.toLowerCase(s1.charAt(l))==Character.toLowerCase(s1.charAt(h)))) return false;
        l++;
        h--;
    }
    return true;

    }
    public boolean validPalindrome(String s) {
        int l=0,h=s.length()-1;
        int le =s.length();
        boolean count = false;
        while(l<h && l<s.length()&&h>=0){

            if(! (Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(h)))){
                char c = s.charAt(h);
                char c1 = s.charAt(l);

                if(!count){
                    if((l+1<s.length() && s.charAt(l+1)==s.charAt(h) ) ) {
                        count = true;
                        l++;
                    } else if(h-1>=0 && (s.charAt(l)==s.charAt(h-1))){
                        count = true;
                        h--;
                    } else{
                        return false;
                    }

                } else {
                    return false;
                }

            }
            l++;
            h--;
        }
        return true;
    }
}
