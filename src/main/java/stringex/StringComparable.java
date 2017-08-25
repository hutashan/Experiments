package stringex;

/**
 * Created by v708178 on 8/15/17.
 */
public class StringComparable implements Comparable<String> {
    String c;
    public StringComparable(String s){
        c=s;
    }

    @Override

    public int compareTo(String o ) {
       if (this.c.charAt(0)<o.charAt(0)){
           return 1;
       } else{
           return -1;
       }

    }
}
