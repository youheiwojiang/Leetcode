public class Solution {
    public int maxProfit(int[] prices) {
        //3d dp
        int len = prices.length;
        if(len == 0) return 0;
        int dp[][] = new int[len][3];
        dp[0][0] = -prices[0];
        for(int i = 1; i< len; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - prices[i]); //buy state
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]); //sell state
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]); //cooldown state
        }
        return Math.max(dp[len-1][1],dp[len-1][2]);
    }
}
