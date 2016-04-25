
public class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length -1; 
        //notice the "=" here handles the 5,1,1 
        while( j > 0 && nums[j]<=nums[j-1]) 
            j--;
        reverse(nums,j,nums.length-1);
        if(j == 0)
            return;
        else{
            for(int i = j;i<nums.length;i++){
                if(nums[i] > nums[j-1]){
                    int tmp = nums[j-1];
                    nums[j-1] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
        return;
        }
        
    }
    void reverse(int[] nums, int i , int j){
        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
