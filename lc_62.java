public class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int j = 0;j<n;j++)
            dp[0][j] = 1;
        for(int i = 1; i< m; i++){
            dp[i][0] = 1;
            for(int j = 1;j< n;j++){//needs attention
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
//////////////////////////////////////////////////////
// O(n) space
public class Solution {
    public int uniquePaths(int m, int n) {
        int cur[] = new int [n];
        for(int i = 0; i< n;i++)
            cur[i] = 1;
        for(int i = 0; i<m-1;i++){
            for(int j = 1; j< n;j++)
                cur[j]+= cur[j-1];
        }
        return cur[n-1];   
    }
}
