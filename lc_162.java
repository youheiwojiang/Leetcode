public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return -1;
        int l = 0, r =nums.length -1,mid = 0;
        while(l <  r){ //always a peak exist in a head and tail all bigger than neighbour
            mid = l + (r- l)/2;
           if(nums[mid] < nums[mid+1])
                l =mid + 1;
            else 
                r = mid ;
        }
        return l;
        
    }
}
