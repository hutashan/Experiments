package G;

public class RepeatedStringMatch {

    public static void main(String arg[]){
        String A = "abcabcabcabc";
        String B = "abac";
        System.out.println(new RepeatedStringMatch().repeatedStringMatch(A,B));
    }

    public int repeatedStringMatch1(String A, String B) {
        StringBuffer newString =new StringBuffer(A);
        int count = 1;
        while(true){
            newString.append(A);
            count ++;

            if(newString.indexOf(B)>=0) return count;
            if(newString.length()+A.length()<B.length()||(A.length()>B.length())) return -1;
        }

    }

    public int repeatedStringMatch(String A, String B) {
        StringBuffer newString =new StringBuffer(A);
        int q=1;
        for(;newString.length()<B.length();q++){
            newString.append(A);
        }
        if(newString.indexOf(B)>=0) return q;
        if (newString.append(A).indexOf(B)>=0) return q++;
        return -1;
    }

}
