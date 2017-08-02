package stringex;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {
    public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
        List<String> ls = sp.permute("AABC".toCharArray());
        for (String l : ls) {
            System.out.println( l);
        }
    }

    public List<String> permute(char input[]) {

        char str[] = "ABC".toCharArray();
        int count[] = {2,1,1};
        int index = 0;

        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }



    public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }

}
