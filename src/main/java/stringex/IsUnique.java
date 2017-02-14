package stringex;


public class IsUnique {
    public static void main (String a[]){
        IsUnique checkUn = new IsUnique();
        System.out.println(checkUn.isUniq("abc"));
        System.out.println(checkUn.isUniq("aaaa"));
        System.out.println(checkUn.isUniq("abaasa"));
        System.out.println(checkUn.isUniq("axdu"));
    }
    public boolean isUniq(String str) {
        if (str.length() > 256) return false;
        boolean[] char_set = new boolean[256];
        for (int i =0; i < str.length();i++){
            int val = str.charAt(i);
            if (char_set[val]){
                return false;
            } else{
                char_set[val] = true;
            }
        }
        return true;
    }
}
