public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length<2) return 0;
        //note when k> n/2 you can make maximum profit still use DP will cause TLE
        if(k >= prices.length/2) return quicksolve(prices);
        int dp[][] = new int[k+1][prices.length];
        for(int j = 1; j<=k;j++){
            int tmpMax = -prices[0];//denote finish at most j-1 transaction in at most i-1 prices also the i price
            for(int i = 1; i< prices.length;i++){
                dp[j][i] = Math.max(dp[j][i-1],tmpMax + prices[i]);
                tmpMax = Math.max(tmpMax,dp[j-1][i-1]-prices[i]);
            }
        }
        return dp[k][prices.length-1];
        
    }
    private int quicksolve(int[]prices){
        int res = 0;
        for(int i = 1; i< prices.length;i++)
            res+= Math.max(prices[i]-prices[i-1],0);
        return res;
    }
}
////////////////////////////////////
//another code similar to k = 2 case:
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length<2) return 0;
        //note when k> n/2 you can make maximum profit still use DP will cause TLE
        if(k >= prices.length/2) return quicksolve(prices);
        int dp[][] = new int[k][2];
        for(int i = 0; i < k;i++) dp[i][0]= Integer.MIN_VALUE;
        for(int price:prices){
            for(int i = k-1;i>=0;i--){
                dp[i][1] = Math.max(dp[i][1],dp[i][0] + price);
                dp[i][0] = Math.max(dp[i][0],(i==0?0:dp[i-1][1])-price);
            }
        }
        return dp[k-1][1];
    }
    private int quicksolve(int[]prices){
        int res = 0;
        for(int i = 1; i< prices.length;i++)
            res+= Math.max(prices[i]-prices[i-1],0);
        return res;
    }
}
