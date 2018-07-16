package ic;

import java.util.HashMap;
import java.util.Map;

public class CoinCollection {
    static Map<String, Integer> memo = new HashMap<>();
    public static void main(String arg[]){


        int[] collection ={1,2,3};
     //   System.out.println(changePossiblity(4,collection,0));
        System.out.println(changePossibilitiesBottomUp(4,collection));


    }
    public static int changePossiblity(int amtLeft,int[] collection,int index){
        if(amtLeft==0){
            return 1;
        }
        if (amtLeft<0) return 0;
        if (index==collection.length) return 0;
        int currCoin = collection[index];
        int numberOfPss =0;
        while(amtLeft>=0){
            numberOfPss +=changePossiblity(amtLeft,collection,index+1);
            amtLeft=amtLeft-currCoin;
        }
        return numberOfPss;
    }
    public static int changePossiblityMemo(int amtLeft,int[] collection,int index){
        String key = amtLeft+","+index;
        if (memo.containsKey(key)) {
            System.out.println("grabbing memo [" + key + "]");
            return memo.get(key);
        }
        if(amtLeft==0){
            return 1;
        }
        if (amtLeft<0) return 0;
        if (index==collection.length) return 0;
        int currCoin = collection[index];
        int numberOfPss =0;
        while(amtLeft>=0){
            numberOfPss +=changePossiblity(amtLeft,collection,index+1);
            amtLeft=amtLeft-currCoin;
        }
        memo.put(key, numberOfPss);
        return numberOfPss;
    }


    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount + 1];  // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }
}
