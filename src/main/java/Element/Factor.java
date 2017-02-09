package Element;


public class Factor {

    public static void main (String a[]){
        primeFactor(10);
    }

    public static void primeFactor(int n) {
        int f = 2;
        for (f=2;f*f<n;f++){
            while (n%f==0){
                System.out.print(f+",");
                n = n /f;
            }
            if (n>1){
                System.out.println(n);
            }

        }

    }
}
