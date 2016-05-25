public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int target = nums[0];
        for(int num:nums){
            if(num == target) count++;
            else count--;
            if(count == 0){
                count = 1;
                target = num;
            }
        }
        return target;
    }
}
