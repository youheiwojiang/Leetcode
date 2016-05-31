public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums.length < 2) return ;
        for(int i = 0; i< nums.length;i+=2){
            if(i>0 &&nums[i] > nums[i-1]) swap(nums,i,i-1);
            if(i+1<nums.length && nums[i] > nums[i+1]) swap(nums,i,i+1);
            
        }
        return;
    }
    private void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
