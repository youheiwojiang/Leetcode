public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2],pred = 0;
        for(int i = 0 ; i< nums.length-2;i++){
            // under this assumption unique sol the next 3 lines are useless
            /*
            if(i > 0 && nums[i] == pred)
                continue;
            pred = nums[i];
            */
            int l = i+1,r = nums.length-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target)
                    return target;
                if(Math.abs(target - sum) < Math.abs(res - target))
                        res = sum;
                if(target > sum)l++;
                else r--;
            }
        }
        return res;
    }
}
