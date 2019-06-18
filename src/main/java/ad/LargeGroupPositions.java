package ad;
import java.util.*;

public class LargeGroupPositions {
    public static void main(String[] args) {
        System.out.println(new LargeGroupPositions().largeGroupPositions("aaa") );
    }

    public List<List<Integer>> largeGroupPositions(String S) {

        List<List<Integer>> result = new ArrayList<>();
        int counter=1;
        int last=0;
        for(int i=1;i<S.length();i++){
            if(S.charAt(i-1)==S.charAt(i)){
                counter++;
            }else {
                if(counter>=3) {
                    List<Integer> ls = new ArrayList<Integer>();
                    ls.add(i-counter);
                    ls.add(i-1);
                    result.add(ls);

                }
                counter=1;

            }
        }
        if(counter>=3) {
            List<Integer> ls = new ArrayList<Integer>();
            int i = S.length()-1;
            ls.add(S.length()-counter);
            ls.add(i);
            result.add(ls);

        }
        return result;
    }
}
