public class Solution {
    public int search(int[] nums, int target) {
        //first find the offset
        int l = 0,r = nums.length - 1,mid = 0;
        while(l < r){
            mid  = l+ (r-l)/2;
            if(nums[mid] > nums[r]) l = mid +1 ;
            else r = mid ;
        }
        // l is the offset
        r = l + nums.length - 1;
        while( l <= r){// if l < r there is condition nums has 1 length and don't enter the loop
            mid = (l + (r-l) / 2 )%nums.length ;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                l++;
            else 
                r-- ;
        }
        return -1;
        
    }
}         
