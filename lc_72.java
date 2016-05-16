public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0 || n == 0)
            return Math.max(m,n);
        int dp[][] = new int[m+1][n+1];
        for(int i = 1;i<=n;i++) dp[0][i] = i;
        for(int j = 1;j<=m;j++) dp[j][0] = j;
        for(int i= 1; i<=m; i++){
            for(int j = 1; j<=n ;j++){//need attention use prefix to determine
                int min1 = 1+Math.min(dp[i-1][j],dp[i][j-1]);
                int min2 = (word1.charAt(i-1) == word2.charAt(j-1)?0:1)+dp[i-1][j-1];
                dp[i][j] = Math.min(min1,min2);
                
            }
        }
        return dp[m][n];
    }
}
