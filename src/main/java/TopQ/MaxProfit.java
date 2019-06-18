package TopQ;

public class MaxProfit {
    public static void main(String[] args) {
        int [] num = {1,2,3,4,5};
        System.out.println(new MaxProfit().maxProfit(num));

    }
    public int maxProfit(int[] stocks) {
    int profit=0;
    for(int i=1;i<stocks.length;i++){
        int dff = stocks[i]-stocks[i-1];
        if(dff>0) profit +=dff;
    }
    return profit;

    }
}








