package F;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";

        System.out.println(new AddBinary().addBinary(a,b));
    }
    public String addBinary(String a, String b) {
        if(a==null && b==null && a.length()==0 && b.length()==0) return null;
        if(a==null && a.length()==0) return b;
        if(b==null && b.length()==0) return a;
        int alen = a.length();
        int blen =b.length();
        StringBuffer sb = new StringBuffer();
        int max_len = Math.max(a.length(),b.length());
        int car =0;
        if(alen<blen){
            int diff = blen-alen;
            StringBuffer as = new StringBuffer();
            for(int i=diff;i>0;i--){
                as.append(0);
            }
            a=as.toString()+a;
        } else if(blen<alen){
            int diff = alen-blen;
            StringBuffer as = new StringBuffer();
            for(int i=diff;i>0;i--){
                as.append(0);
            }
            b=as.toString()+b;
        }
        for(int i=max_len-1;i>=0;i--){
            int aelem=a.charAt(i)-'0';
            int belem=b.charAt(i)-'0';

            int result = aelem+belem+car;
            if(result==3){
                sb.append("1");
                car=1;
            } else if(result==2){
                sb.append(0);
                car=1;
            } else{
                sb.append(result);
                car=0;
            }

        }
        if(car==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}
