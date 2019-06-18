package a;
import java.util.*;

public class GenerateFebonacci {
    static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) {
            int len = 1;
            String s = "123456579";
            while(l.size() == 0 && len<s.length()){
                generateFebonacci(s, 0, len);
                len++;
            }
            System.out.println(l.toString());
    }
    public static void generateFebonacci(String s, int i, int len){
        if(s.length()<i+len){
            if(i < s.length()){
                l = new ArrayList<>();
            }
            return;
        }
        if(l.size()<2){
            l.add(Integer.parseInt(s.substring(i, i+len)));
        }
        else{
            int n = l.size();
            int n1 = l.get(n-1);
            int n2 = l.get(n-2);
            int n3 = Integer.parseInt(s.substring(i,i+len));
            if(n1+n2 == n3){
                l.add(n3);
            }
            else{
                l = new ArrayList<>();
                return;
            }
        }
        generateFebonacci(s, i+len, len);
    }

}
