  public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE,maxsofar = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){
            maxsofar = maxsofar >=0 ? nums[i]+maxsofar:nums[i];
            max = Math.max(max,maxsofar);
        }
        return max;
    }
}
