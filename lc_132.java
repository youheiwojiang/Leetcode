public class Solution {
    public int minCut(String s) {
        int dp[] = new int[s.length()+1];
        boolean palin[][] = new boolean[s.length()][s.length()];
        for(int i = 0; i< s.length();i++){
            for(int j = 0; j<=i;j++){
                if(j == i) palin[j][i] = true;
                else{
                    if(s.charAt(i) == s.charAt(j) && (i == j+1 ||palin[j+1][i-1]) )
                        palin[j][i] = true;
                }
            }
        }
        for(int i = 1;i<= s.length();i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<i;j++){
                if(palin[j][i-1] && dp[j] != Integer.MAX_VALUE)
                    min = Math.min(min,dp[j] + 1);
            }
            dp[i] = min;
        }
        return dp[s.length()] -1 ;
    }
    /*private boolean isPalindrome(String s, int l, int r){
        while( l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }*/
}
