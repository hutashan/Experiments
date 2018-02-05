package stringex;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {
    public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
      //  sp.permute1("AABC".toCharArray(),"");

         List<String> ls = sp.permute("AABC".toCharArray());
        for (String l : ls) {
            System.out.println( l);
        }
    }
    public void permute1(char input[],String res) {
        if (res.length()==input.length){
            System.out.println(res);
            return;
        }

        for (int i=0;i<input.length;i++){
            while((i+1)<input.length && input[i]==input[i+1]){
                i++;
            }
            permute1(input,res+input[i]);
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
