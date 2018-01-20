package arrays.operation;

public class Best_Time_to_Buy_and_Sell_Stock_3 {
    public int maxProfit(int[] prices) {
        int hold1=Integer.MAX_VALUE,hold2=Integer.MAX_VALUE;
        int sell1=0,sell2=0;
         for(int i:prices){
             sell2=Math.max(sell2,i-hold2);
             hold2=Math.min(hold2,i-sell1);
             sell1=Math.max(sell1,i-hold1);
            hold1=Math.min(hold1,i);
        }
        return sell2;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length<=0) return 0;
        int[][] dp =new int[2+1][prices.length];
        for(int i=1;i<dp.length;i++){
            int temp=dp[i-1][0]-prices[0];
            for(int j=1;j<prices.length;j++){
                dp[i][j]=Math.max(dp[i][j-1],temp+prices[j]);
                temp=Math.max(temp,dp[i-1][j]-prices[j]);
            }
        }
        return dp[2][prices.length-1];
    }
}
