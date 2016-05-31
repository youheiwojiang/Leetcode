public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int row = costs.length,col = costs[0].length;
        int dp[][] = new int[row][col];
        int min1 = -1,min2 = -1;
        for(int i = 0; i< row; i++){
            int last1 = min1,last2 = min2;
            min1 = -1;min2 = -1;
            for(int j = 0; j< col ;j++){
                if(j != last1) {
                    dp[i][j] = (last1<0?0:dp[i-1][last1])+costs[i][j];
                }
                else {
                    dp[i][j] = costs[i][j] + (last2<0?0:dp[i-1][last2]);
                }
                if(min1 < 0 || dp[i][j] < dp[i][min1]){
                    min2 = min1;min1 = j; //keypart
                }else if(min2 < 0 || dp[i][j] < dp[i][min2])
                    min2 = j;
            }
        }
        return dp[row-1][min1];
    }
}
