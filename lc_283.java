public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]!=0) nums[index++] = nums[i];
        }
        for(int i = index;i<nums.length;i++)
            nums[i] = 0;
        return ;
        
    }
    private void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
