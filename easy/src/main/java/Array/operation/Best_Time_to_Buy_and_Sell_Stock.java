package Array.operation;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                if(prices[j]-prices[i]>profit) profit=prices[j]-prices[i];
            }
        }
        return profit;
    }
}
