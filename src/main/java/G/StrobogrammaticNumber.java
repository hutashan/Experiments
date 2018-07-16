package G;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumber {
    public static void main(String arg[]){
        List<String>  ls = new StrobogrammaticNumber().findStrobogrammatic(3);
        for(int i=0;i<ls.size();i++){
            System.out.println(ls.get(i));
        }

    }

    public void helper(List<String> l, int n, int cur, String s){
        if(n == cur){
            l.add(s);
            return;
        }
        if(n-2 != cur){
            helper(l,n,cur+2,"0"+s+"0");
        }
        helper(l,n,cur+2,"1"+s+"1");
        helper(l,n,cur+2,"8"+s+"8");
        helper(l,n,cur+2,"6"+s+"9");
        helper(l,n,cur+2,"9"+s+"6");
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> l = new ArrayList();
        if(n % 2 == 0){
            helper(l, n, 0, "");
        }else{
            helper(l, n-1, 0, "0");
            helper(l, n-1, 0, "1");
            helper(l, n-1, 0, "8");
        }
        return l;
    }
}
