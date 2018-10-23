package F;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        List<String> ls  = new LetterCombinationsPhoneNumber().letterCombinations("23");
        for(String s : ls){
            System.out.println(s);
        }

    }
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
