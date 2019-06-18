package a;
import java.util.*;
public class LetterCombinations {
    List<String> result = new ArrayList<>();
    public static void main(String[] args) {

        LetterCombinations le = new LetterCombinations();
        List<String> res = le.letterCombinations("23");
        for(String st:res){
            System.out.println(st);
        }
    }
    public List<String> letterCombinations1(String digits) {

        letterCombinations(digits,"",0);
        return result;

    }
    public void letterCombinations(String digits,String res,int index) {
        if(res.length()==digits.length()) {result.add(res); return;}
        if(index>=digits.length()) return;

        String[] dic = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int dicIndex = digits.charAt(index)-'0';
        char[] arrc = dic[dicIndex].toCharArray();
        for(int i=0;i<arrc.length;i++){
            letterCombinations(digits,res+arrc[i],index+1);
        }

    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }

}
