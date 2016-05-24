public class Solution {
    public int findMin(int[] nums) {
        int l = 0 , r = nums.length -1 ;
        int mid = 0;
        //int target = nums[0];
        while(l < r ){
            mid = l + (r- l)/2;
            if(nums[mid] > nums[r])
                l = mid + 1;
            else if(nums[r] > nums[mid])
                r = mid;
            else
                r--;
        }
        return nums[l];
        
    }
}
