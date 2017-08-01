package stringprob;

/**
 * Created by parmana on 7/13/17.
 */
public class ResverStrByRec {

    public static void main(String[] args) {

        System.out.println(rev1("abcdefgh","abcdefgh".length()-1));
    }


    public static String rev(String s,int len){
        if(s.length()==1)
            return s;
     return s.charAt(len - 1) + rev(s.substring(0, len - 1), s.length()-1);

    }

    public static String rev1(String s,int len){
        if(s==null)
            return "";
        return s.charAt(len) + rev(s.substring(0, len), s.length()-1);

    }

}
