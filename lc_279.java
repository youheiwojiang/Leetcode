public class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i =1; i<=n;i++){
            int tmp = i;
            for(int j = 1; j*j<=i;j++){
                tmp = Math.min(tmp,1+dp[i-j*j]);
            }
            dp[i] = tmp;
        }
        return dp[n];
    }
}
