public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return wordDict.contains("");
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i<=s.length();i++){
            for(String word:wordDict){
                if(word.length() <= i && dp[i-word.length()] && word.equals(s.substring(i-word.length(),i)) ){
                    dp[i] = true;
                    break;//it can increase time efficiency
                }
            }
        }
        return dp[s.length()];
    }
}
