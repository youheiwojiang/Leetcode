public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int res = 0;
        int row = matrix.length,col = matrix[0].length;
        int dp[][] = new int[row+1][col+1];
        for(int i = 1; i<= row; i++){
            for(int j = 1; j<=col;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    res = Math.max(res,dp[i][j]);
                }
            }
        }return res*res;
    }
}
