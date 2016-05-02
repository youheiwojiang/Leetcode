    public class Solution {
    public void sortColors(int[] nums) {
        int ones = 0, zeros = 0, twos = 0;
        for(int num : nums){
            if(num == 0){
                nums[twos++] = 2;
                nums[ones++] = 1;
                nums[zeros++] = 0;
            }else if(num == 1){
                nums[twos++] = 2;
                nums[ones++] = 1;
            }else{
                nums[twos++] = 2;
            }
        }
        return ;
    }
}
