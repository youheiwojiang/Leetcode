  public class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for(int i = 0; i<=Math.min(nums.length-1,max); i++){
            max = Math.max(max,i+nums[i]);
        }
        return max >= nums.length-1;   
        /*
         int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max) {return false;}
                 max = Math.max(A[i]+i,max);
                 }
         return true;
    */
    }
}
