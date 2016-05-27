public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length < 1) return 0; //keypart
        int l = 0,r = 0,sum = 0,min = Integer.MAX_VALUE;
        while(r < nums.length){
            while(r< nums.length && sum < s){
                sum+= nums[r++];
            }
            if(s > sum) break; //keypart can not return since the last may not exceed s
            while(l < r && sum >= s){
                sum-= nums[l++];
            }
            min = Math.min(min, r -l+1);
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}
