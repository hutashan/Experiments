package simpleprob;



public class StringHasUniqueChar {

    public static void main(String[] args) {



        String s ="abcderfghi";
        char arr[] = s.toCharArray();
        boolean barr[] = new boolean[128];
        for(char c:arr){
            System.out.println(1>>c-'a');
            if(barr[c]==true){
                System.out.println("Not unique");
                System.exit(0);
            } else {
                barr[c]=true;
            }
        }
        System.out.println("All unique");

    }
}
