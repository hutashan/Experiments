package a;
import java.util.*;

public class GenerateParenthesis {
    static List<String> res = new ArrayList<>();
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) {

        GenerateParenthesis gen = new GenerateParenthesis();
        gen.generateParenthesis(3);
        for (String s : res) {
            System.out.println(s);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        char[] chs = new char[2*n];
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}
