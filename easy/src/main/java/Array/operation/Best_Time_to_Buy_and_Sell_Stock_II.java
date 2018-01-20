package Array.operation;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int profit=0;
        int vally=Integer.MAX_VALUE;
        int tempProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<vally){
                vally=prices[i];
                profit+=tempProfit;
                tempProfit=0;
            }else{
                if(prices[i]-vally>tempProfit){
                    tempProfit=prices[i]-vally;
                }else{
                    profit+=tempProfit;
                    vally=prices[i];
                    tempProfit=0;
                }
            }
        }
        profit+=tempProfit;
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                profit+=prices[i]-prices[i-1];
        }
        return profit;
    }


    public static void main(String[] args){
        int[] nums={2,1,2,0,1};
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_II().maxProfit(nums));
    }
}
