public class Solution {
    public int numDistinct(String s, String t) {//two string input dp consider two dimension array
        int m = s.length(), n = t.length();
        int [][]dp = new int[m+1][n+1];
        for(int i = 0; i<=m; i ++){
            for(int j = 0; j<=n; j++){
                if( j == 0) {dp[i][j] = 1;continue;}
                else if(i == 0){continue;}
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}
