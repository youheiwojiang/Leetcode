public class Solution {//find target using <=
    public boolean search(int[] nums, int target) {
        int l = 0 ,r = nums.length-1,mid = 0;
        while( l <= r){   // needs attention
            mid = l + (r -l)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > nums[l]){// left is sorted
                if(target < nums[mid] && target >= nums[l]){
                    r = mid-1;
                }else{
                    l = mid +1;
                }
            }else if(nums[mid] < nums[l]){//right is sorted
                if(target > nums[mid] && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            else l++;
        }
        return false;
    }
}
