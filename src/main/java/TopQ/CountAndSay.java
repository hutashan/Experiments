package TopQ;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(7));
    }
    public String countAndSay(int n) {
        String result ="1";
        for(int i=1;i<n;i++){
            result =countAndSay(result);
        }
        return result;

    }
    private String countAndSay(String s){
        boolean flag;
        int count =1;
        StringBuilder result =new StringBuilder();
        Character c= null;
        for(int i=0;i<s.length();i++){
             c = s.charAt(i);
            for(int j=i+1;j<s.length();j++){
                if(c==s.charAt(j)){

                   count++;
                }else{
                    result.append(count);
                    result.append(c);
                   count=1;
                   i=j-1;
                   break;
                }
            }

        }
        result.append(count);
        result.append(c);
        return result.toString();
    }
}
