// It's a more concise version 
class Solution {
public:
    int findMin(vector<int>& nums) {
        int i,l=0,r=nums.size()-1,mid;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(nums[r]<=nums[mid])l=mid+1;
            else r=mid;
        }
        return nums[r];
    }
};

////////////////////////////////////////
//it 's my verison:
public class Solution {
    public int findMin(int[] nums) {
        int l = 0 , r = nums.length -1 ;
        int mid = 0;
        int target = nums[0];
        while(l <= r ){
            mid = l+(r-l)/2;
            if(nums[mid] < target){
                r = mid - 1;
            }else //if(nums[mid] >= nums[l]){
            {
                l = mid + 1;
            }
            
        }
        return l==nums.length?nums[0]:nums[l];
        
    }
} 
