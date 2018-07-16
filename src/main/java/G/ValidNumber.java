package G;

public class ValidNumber {
    public static void main(String arg []){
        String s = "1 ";
        System.out.println(new ValidNumber().isNumber(s));
    }

    public boolean isNumber(String s) {
        if(s.equals(".")) return false;
        for(int i=0;i<s.length();i++){

            if(!Character.isDigit(s.charAt(i))){
                if(s.charAt(i)!='.' || s.charAt(i)!=' ') return false;
            }

        }
        return true;
    }
}
