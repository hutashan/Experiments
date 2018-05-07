package arr;

public class NumMatchingSubseq {
    public static void main(String arg[]){
       String S = "abcde";
       String [] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(S,words));

    }
   static public int numMatchingSubseq(String S, String[] words) {
        int counter =0;
        for (int i=0;i<words.length;i++){
            int k=0,j=0;
            while(S.length()!=k && words[i].length()>j){
                if (S.charAt(k) == words[i].charAt(j)) {
                    k++;
                    j++;
                } else {
                    k++;
                }
            }
            if(j==words[i].length()){
                counter ++;
            }

        }
        return counter;
    }

}
