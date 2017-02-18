package simpleprob;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by parmana on 2/2/17.
 */
public class Gcd {

    public static void main(String[] args) {
      List l= new ArrayList();
       // System.out.println(new Random().nextInt(5));
       Random rn= new Random();
        rn.setSeed(10);
        System.out.println(rn.nextLong());
        System.out.println(gcd(10,12));
        System.out.println(gcd2(10,12));
    }


    public static int gcd(int p,int q){
        if(q==0) return p;
        else
          return   gcd(q,p%q);
    }

    public static int gcd2(int p,int q){
      while (q!=0){
          int temp=q;
          q=p%q;
          p=temp;
      }
        return p;
    }


}
