public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int dp[] = new int[n];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i< n; i++){
            for(int j = i; j>=0; j--){
                //if(j == 0) dp[0]+= list.get(i).get(0);
                if(j == 0) dp[0]+=triangle.get(i).get(0);
                else if(j == i) dp[j] =triangle.get(i).get(j) + dp[j-1];
                else dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int val : dp){
            min = Math.min(min,val);
        }
        return min;
    }
}
