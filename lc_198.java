public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int dp[][] = new int[nums.length][2];
        dp[0][0] = nums[0];
        for(int i = 1; i< nums.length;i++){
            if(i ==1){ dp[1][0] = nums[1];dp[1][1] = nums[0];}
            else{
                dp[i][0] = nums[i] + dp[i-1][1];
                dp[i][1] = Math.max(dp[i-1][0],dp[i-2][0]);
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
