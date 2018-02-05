package simpleprob;

public class Test1232 {

    static public int numberOfCubePaint(int n)  {
        if (n<0){
            throw new IllegalArgumentException("this number cannot be negative");
        }
        if (n==0) return 0;
        else if (n==1) return 1;
        else
            return 8+(12 * (n-2))+((n-2)*(n-2)*6);
    }

}





























