package G;

public class CanTransform {

    public static void main(String[] args) {
        String start = "XXRXXLXXXX";
        String end = "XXXXRXXLXX";
        System.out.println(new CanTransform().canTransform(start,end));
    }


    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
      //  System.out.println(start.replace("X", ""));
     //   System.out.println(end.replace("X", ""));
        int p1=0;
        int p2=0;
        while(p1<start.length() & p2<end.length()){
            while(p1<start.length() && start.charAt(p1)=='X') p1++;
            while(p2<end.length() && end.charAt(p2)=='X') p2++;

            if(p1 == start.length() && p2 == end.length()){
                return true;
            }
            if(p1 == start.length() || p2 == end.length()){
                return false;
            }
            if(start.charAt(p1)!=end.charAt(p2)) return false;
            // if the character is 'L', it can only be moved to the left. p1 should be greater or equal to p2.
            if(start.charAt(p1) == 'L' && p2 > p1){
                return false;
            }
            // if the character is 'R', it can only be moved to the right. p2 should be greater or equal to p1.
            if(start.charAt(p1) == 'R' && p1 > p2){
                return false;
            }




            p1++;
            p2++;

        }
        return true;

    }
}
