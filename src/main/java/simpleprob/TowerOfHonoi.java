package simpleprob;

/**
 * Created by parmana on 4/6/17.
 */
public class TowerOfHonoi {


    public static void tower(int n,char source,char destination,char buffer){

        if (n==0)
            return;

        tower(n-1,destination,buffer,source);

        System.out.println("move from "+ n +"Source "+source +"destination "+destination);
        tower(n-1,buffer,source,destination);

    }


    public static void main(String[] args) {

       tower(3,'s','d','a');

    }

}
