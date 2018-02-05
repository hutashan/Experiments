package stringex;

import java.util.HashSet;

public class ReverseVowel {
    public static void main(String arg []){
        System.out.println(reverseVowel("realtor"));
    }

    public static String reverseVowel(String st) {
        HashSet<String> vowel =new HashSet<String>();
        vowel.add("a");
        vowel.add("e");
        vowel.add("i");vowel.add("o");vowel.add("u");
        char[] vowelString=new char[st.length()] ;
        int j =0;

        for (int i=0;i<st.length();i++){
            if (vowel.contains(st.charAt((i)))){
                vowelString[j] = st.charAt(i);
                j++;

            }

        }
        char[] result = st.toCharArray();
        for (int i=0;i<st.length();i++){
            if (vowel.contains(st.charAt(i))){
                result[i]=vowelString[j];
                j--;

            }



        }
        System.out.printf(result.toString());
        return result.toString();
}

}
