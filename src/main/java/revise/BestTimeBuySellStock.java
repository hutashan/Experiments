package revise;

public class BestTimeBuySellStock {

    public static void main(String[] args) {
        int [] input = {7,1,5,3,6,4};
        System.out.println(new BestTimeBuySellStock().maxProfit(input));

    }
    public int maxProfit(int[] prices) {
        int max = 0;
        int minVal =prices[0];
        for(int i=1;i<prices.length;i++){
            minVal = Math.min(minVal,prices[i-1]);
            if(minVal<prices[i]){
                max = Math.max(prices[i]-minVal,max);
            }
        }
        return max;

    }

}
