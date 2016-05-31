public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length < 1) return -1;
        int fast = nums[nums[0]], slow = nums[0];
        while(slow != fast){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}

/////////my comprehensive code:
public class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length-1,mid = 0;
        while(l < r){
            mid = l + (r - l)/2;
            int count = 0;
            for(int num:nums)
                if(num <= mid)
                    count++;
            if(count <= mid)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
