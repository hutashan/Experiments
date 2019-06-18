package ad;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] input = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(input));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        String res = strs[0];
        for(int i=1;i<strs.length;i++){
            int v =res.indexOf(strs[i]);
            while(strs[i].indexOf(res)!=0){
                res=(res.substring(0,res.length()-1));
            }
        }
        return res.toString();
    }

}
