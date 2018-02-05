package arr;


public class CountAndSay {

    public static void main(String arg[]){
        int n =6;
        int i=1;
        StringBuffer number = new StringBuffer("1");

        System.out.println("1");
        while(i<=n){
            StringBuffer result = new StringBuffer();
            char[] c = number.toString().toCharArray();
            int count=1;

            for (int j=1;j<c.length;j++){
            if (c[j]==c[j-1]){
                count++;
            } else {
                result.append(count) ;
                result.append(c[j-1]);
                count = 1;
             }
            }
            result.append(count);
            result.append(c[c.length - 1]);
            number=result;
            System.out.println(number);
            i++;
        }
        System.out.println( number.toString());
    }



}
