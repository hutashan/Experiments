package ic;

public class BestStock {
    public static void main(String arg[]){
        int[] stk = {3,3,5,0,0,3,1,4};
        System.out.println(new BestStock().maxProfit(stk));
    }



        public int maxProfit(int[] prices) {
            int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                buy1 = Math.max(buy1, - prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }













        public int maxProfitVeryEasy(int[] prices) {
            if (prices.length==0) return 0;
            int maxProfit =0;
            int leastPrice = prices[0];
            for(int currentPrice : prices){
                leastPrice = Math.min(currentPrice,leastPrice);
                int currentProfit = currentPrice-leastPrice;
                maxProfit = Math.max(maxProfit,currentProfit);
            }
            return maxProfit;
        }










    public int maxProfitEasy(int[] stocks) {
        if(stocks.length==0) return 0;
        int maxProfit =0;
        int cummMax =0;
        int leastPrice = stocks[0];
        int previous = stocks[0];
        int cp =0;
        for(int currentPrice : stocks){
            cp =currentPrice ;
            leastPrice = Math.min(currentPrice,leastPrice);

            int currentProfit = currentPrice-leastPrice;

            maxProfit = Math.max(maxProfit,currentProfit);
            if(previous>currentPrice){
                cummMax =maxProfit +cummMax;
                maxProfit=0;
                leastPrice=currentPrice;
            }
            previous = currentPrice;

        }


        return cummMax+maxProfit;
    }
}
