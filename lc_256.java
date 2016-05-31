public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int m = costs.length,n = costs[0].length;
        int[][]dp = new int[m+1][n];
        for(int i = 1;i<=m;i++){
            dp[i][0] = costs[i-1][0]+Math.min(dp[i-1][1],dp[i-1][2]);
             dp[i][1] = costs[i-1][1]+Math.min(dp[i-1][0],dp[i-1][2]);
              dp[i][2] = costs[i-1][2]+Math.min(dp[i-1][1],dp[i-1][0]);
        }
        return Math.min(dp[m][0],Math.min(dp[m][1],dp[m][2]));
    }
}
