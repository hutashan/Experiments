package stringex;

public class LongestSubStringDistinctChar {
    public static void main(String a[]){
        String s="findlongestsubstring";
        longestDistinctSubstring(s,s.toCharArray());
    }

     public static void longestDistinctSubstring(String s,char[] str){
        boolean[] window = new boolean[128];
         int begin =0,end =0;
         for (int low=0,high=0;high<str.length;high++){
             System.out.println(" str[high] " +str[high] + "  str[low]  "+ str[low] +"  begin " + begin +" end "+end+" low "+low+" high "+high);
             if(window[str[high]]){

                 while(str[low]!=str[high]){
                     int i = str[low++];
                     window[i]=false;

                 }
                 low++;

             } else{

                 window[str[high]]=true;
                 if(end-begin<high-low){
                     begin=low;
                     end=high;
                 }

             }
         }
         System.out.printf(s.substring(begin,end+1));
    }
}
