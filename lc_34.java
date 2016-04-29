// this is my original version
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l= 0,r = nums.length - 1,mid = 0,left = -1;
        boolean flag = false;
        int res[] = new int[2];
        res[0] = res[1] = -1;
        while(l <= r){
            mid = l+ (r-l)/2;
            if(nums[mid] < target )
                l = mid + 1;
            else{
                if(nums[mid] == target)
                    flag = true;//to handle one element in nums(length = 1)
                r = mid -1;
            }
        }
        left = flag?l:-1;
        if(left == -1)
            return res;
        l = 0;
        r = nums.length -1; 
        while(l <= r){
            mid = l+ (r-l)/2;
            if(nums[mid] > target )
                r = mid -1;
            else
                l = mid +1;
        }
        res[0] = left;
        res[1] = r;
        return res;
    }
}

///////////////////////////////////////////////////////////////////////////////////
