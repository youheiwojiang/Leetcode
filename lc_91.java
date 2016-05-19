public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) 
            return 0;
        int[] dp = new int[s.length()+1];//here dp[i] means ways to decode a str of size i more comprehensive!
        dp[0] = 1
        dp[1] = (s.charAt(0)>'0' && s.charAt(0)<='9')?1:0;
        for(int i = 2; i<= s.length();i++){
            char c = s.charAt(i-1);
            String tmp = s.substring(i-2,i);
            if(Integer.parseInt(tmp) <=26 &&Integer.parseInt(tmp) >=10)
                dp[i]+= dp[i-2];
            if(c-'0' > 0 && c-'0' <=9)
                dp[i]+= dp[i-1];
        }
        return dp[s.length()];
    }
}
