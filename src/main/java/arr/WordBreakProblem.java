package arr;


import java.util.HashSet;

public class WordBreakProblem {
    public static void main(String arg[]){
        String str="wordbreakproblem";
        HashSet<String> dic =new HashSet();
        dic.add("this");
        dic.add("th");
        dic.add("word");
        dic.add("break");
        dic.add("br");
        dic.add("eak");
        dic.add("problem");
        wordBreakUtil(str,dic,"",str.length());

    }

    public static void wordBreakUtil(String str,HashSet<String> dic,String result,int size){
        if(0==size){
            System.out.println(result);
            return;
        }
        for(int i=1;i<=size;i++){
            String prefix = str.substring(0,i);
            if(dic.contains(prefix)){
                    result = result+","+prefix;

                wordBreakUtil(str.substring(i),dic,result,size-i);
            }
        }

    }



}
