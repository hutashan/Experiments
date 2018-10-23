package F;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "112" ;

        int k = 1;
        System.out.println(new RemoveKDigits().removeKdigits(num,k));
    }

    public String removeKdigits(String num, int k) {
        if(num==null) return "0";
        if(k==0) return num;

        StringBuffer sb= new StringBuffer();
        int len = num.length();

        for(int i=1;i<num.length();i++){

            boolean com = num.charAt(i-1)>=num.charAt(i);
            if(k>0 && (com || num.charAt(i)=='0') ){
                 k--;
            } else{
                if(num.charAt(i-1)=='0' && sb.length()==0){
                    sb.append("");
                } else {
                    if(i-1<len) {
                        sb.append(num.charAt(i - 1));
                    } else{
                        if(com){
                            sb.append(num.charAt(i - 1));
                        }else {
                            sb.append(num.charAt(i ));
                        }
                    }
                }
            }


        }
        if( k==0) {
            sb.append(num.charAt(num.length()-1));
        }
        if(sb.length()==0){
            sb.append("0");
        }
        return sb.toString();
    }



}
