package stringex;


public class CompressBetter {
    public static void main (String a[]){
       // System.out.println(String.valueOf(322).length());
        System.out.println(compress("aabbxv"));
    }
    public static String compress(String str) {

        char[] arr = str.toCharArray();
        int i=0;
        char prev = arr[i];
        int count =1;
        String compressStr = "";
        for (i=1;i<arr.length;i++){

            if (prev==arr[i]){
                count ++;
            } else {
                compressStr = compressStr + prev + count;
                prev = arr[i];
                count =1;

            }
        }
        compressStr = compressStr + prev + count;
        return compressStr;
    }
}
