package G;

import arr.MaxiumProducts;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class MaximumProductWordLengths {
    public static void main(String arg[]){
        String[] input = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(new MaximumProductWordLengths().maxProduct(input));
    }


    public int maxProduct(String[] words) {
        if(words == null || words.length <= 1) return 0;
        int res = 0;
        for(int i = 0; i < words.length; i ++){
            for(int j = i + 1; j < words.length; j ++){
                if(!hasCommon(words[i], words[j])) res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;


    }

    // (k1 + k2)
    private boolean hasCommon(String word1, String word2){
        int mask1 = 0;
        int mask2 = 0;
        for(int i = 0; i < word1.length(); i ++){
            int pos = word1.charAt(i) - 'a';
            mask1 |= (1 << pos);
        }
        for(int i = 0; i < word2.length(); i ++){
            int pos = word2.charAt(i) - 'a';
            mask2 |= (1 << pos);
        }
        return (mask1 & mask2) != 0;
    }

}
