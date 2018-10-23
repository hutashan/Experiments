package failure;

public class NumberMatchingSubsequences {


    public static void main(String[] args) {
        String [] words={"a","bb","acd","ace"};
        String s ="abcde";
        System.out.println(new NumberMatchingSubsequences().numMatchingSubseq(s,words));
    }
    public int numMatchingSubseq(String S, String[] words) {
        if(words.length==0) return 0;
        if(S.length()==0) return 0;
        int count =0;

        for(String word : words){
            int countMatch=0;
            int j=0;
            for (int i=0;i<word.length();){
                if(j>=S.length()){
                    break;
                }
                for(;j<S.length();){
                    if(S.charAt(j)==word.charAt(i)){
                        i++;
                        countMatch ++;
                        j++;
                        break;
                    }
                    j++;
                }
            }
            if(countMatch==word.length()){
                count++;
            }
        }
        return count;
    }
}
