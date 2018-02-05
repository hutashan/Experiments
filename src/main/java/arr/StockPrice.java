package arr;

import datastructure.In;

public class StockPrice {
    public static void main(String a[]){
        int [] arr = {1,3,2,8,4,9};
        maxProfit1(arr,2);
    }


    public static void profilt(){
        int [] arr = {3,2,1,4,5,2,4,7};
        int total =0;
        int j =0;

        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i] ) {
                j = i;
            }

            if (arr[i-1]<arr[i] && ((i+1==arr.length) || (arr[i]>arr[i+1]))){
                total = total+(arr[i]-arr[j]);
                System.out.println(arr[j]+" "+arr[i]);

            }

        }
        System.out.println("total  is " + total);
    }
     static public int maxProfit(int[] prices, int fee) {
        int l = prices.length;
        int[] hold = new int[l + 1]; //Hold the stock until day i;
        int[] notHold = new int[l + 1]; //Do not hold the stock until day i;
        hold[0] = Integer.MIN_VALUE;

        for (int i = 1; i <= l; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i - 1] - fee);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i - 1]);
        }

        return notHold[l];
    }


    public static int maxProfit1(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        System.out.printf(cash+"");
        return cash;
    }


}
