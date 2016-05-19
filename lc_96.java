public class Solution {
    public int numTrees(int n) {
        
     //int count = 0;
        if(n<=0) return 0;
        int []dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<= n; i++){
            int count  = 0;
            for(int j = 0; j<=i-1;j++)
                count+= dp[j] * dp[i-1-j];
            dp[i] = count; // need attention
        }
        return dp[n];
    }
   
}
