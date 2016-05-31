public class Solution {
    public int hIndex(int[] citations) {
        //if(citations.length < 1) return 0;
        int[]dp = new int[citations.length+1];
        for(int citation:citations){
            if(citation >= citations.length)
                dp[citations.length]++;
            else
                dp[citation]++;
        }
        int sum = 0;
        for(int i = citations.length; i>= 0; i--){
            sum += dp[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
}
