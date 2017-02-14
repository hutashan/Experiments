package stringex;


public class StringReverse {

    public static void main(String[] args) {

        String s="abhctyu is ujfdf\0";
        rev(s);
    }
    public static void rev(String s){

        char arr[]= s.toCharArray();
        int lenth = arr.length;
        for(int i=lenth-2;i>=0;i--){
            System.out.print(arr[i]);
        }

    }
}
