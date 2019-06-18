package G;


import java.util.*;


public class FindReplaceString {
    public static void main(String[] args) {
       String s = "jjievdtjfb";
        int[] indexes = {4,6,1};
        String [] sources = {"md","tjgb","jf"}, targets = {"foe","oov","e"};
        System.out.println(new FindReplaceString().findReplaceString(s,indexes,sources,targets));
    }
    public String findReplaceStringSlow(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(S);
        List<int[]> sortedList = new ArrayList<>();
        for(int i=0;i<indexes.length;i++) sortedList.add(new int[]{indexes[i],i});
        Collections.sort(sortedList, Comparator.comparing(i -> -i[0]));
        for(int[] index : sortedList ){
            int startInd = index[0];
            int actual = index[1];
           // System.out.println(sources[actual]);
          //  String c = S.substring(startInd,startInd+sources[actual].length());
          //  System.out.println("c=="+c);
            if(sources[actual].equals(S.substring(startInd,startInd+sources[actual].length()))){
                sb.replace(startInd,startInd+sources[actual].length(),targets[actual]);
            }

        }
        return sb.toString();
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int [] match = new int[S.length()];
        Arrays.fill(match,-1);
        for(int i=0;i<indexes.length;++i){
            int ix = indexes[i];
            if(S.substring(ix,ix+sources[i].length()).equals(sources[i])){
                match[ix]=i;

            }

        }
        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while(ix<S.length()){
            if(match[ix]>0){
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            }
            ans.append(S.charAt(ix++));
        }
        return ans.toString();
    }
}
