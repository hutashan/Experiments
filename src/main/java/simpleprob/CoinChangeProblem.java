package simpleprob;

import java.util.List;

/**
 * Created by parmana on 3/15/17.
 */
public class CoinChangeProblem {


    public static void main(String[] args) {
        int coin[]={50,25,10,5,1};
        //int coin[]={1,50};
        int money=17;
        System.out.println(makeChange(coin,money,0));

        List l= new java.util.ArrayList();
        l.add(2);
        System.out.println(l.get(0));

    }

    public static long makeChange(int[] coins,int money,int index){
        if(money==0)
            return 1;
        if(index>=coins.length)
            return 0;

        long way=0;
        int amountWithCoin=0;

        while (amountWithCoin<=money){

            int remaing= money-amountWithCoin;
            way+=makeChange(coins,remaing,index+1);
            amountWithCoin+=coins[index];
        }
     return way;


    }

}
