package stringex;


import java.util.HashMap;

public class Interleaving {

    public static void main(String a[]){
        String X ="AB";
        String Y= "CD";
        String S ="ACBD";
        HashMap<String,Boolean> hs = new HashMap<String,Boolean>();
        System.out.print(interLeaving(X,Y,S,hs));

    }

    public static boolean interLeaving(String X , String Y, String S,HashMap<String,Boolean> hs){
        if (X.length()==0 && Y.length()==0 && S.length()==0){
            return true;
        } else if (S.length()==0){
            return false;
        }
        String key = X+"|"+Y+"|"+S;
        if (!hs.containsKey(key)) {
            boolean y=false,x = false;
            if (X.length() != 0 && X.toCharArray()[0] == S.toCharArray()[0]) {
                 x= interLeaving(X.substring(1), Y, S.substring(1), hs);
            }  if (Y.length() != 0 && Y.toCharArray()[0] == S.toCharArray()[0]) {
                 y= interLeaving(X, Y.substring(1), S.substring(1), hs);
            }
            boolean v = x||y;
            hs.put(key,v );
        } else{
            hs.get(key);
        }
        return false;
    }

}
