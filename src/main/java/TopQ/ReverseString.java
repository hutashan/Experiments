package TopQ;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverse(1534236469));
    }

    public int reverse(int x){
        int result = 0;
        while(x!=0) {
            int mod = x % 10;
            result = result * 10 + mod;
            x = x / 10;
        }
       // System.out.println(result);
        return result;
    }


    public String reverseString(String s) {
        if(s==null || s.length()==0) return null;
        int start =0;
        int end = s.length()-1;
        char [] arrString = s.toCharArray();
        while(start<end){
            char temp = arrString[start];
            arrString[start]=arrString[end];
            arrString[end]=temp;
            start++;
            end--;
        }
        return new String(arrString);
    }
}
