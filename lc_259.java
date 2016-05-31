public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0;i<nums.length- 2;i++){
            int l = i+1,r = nums.length-1;
            while(l < r){
                int val = nums[i] + nums[l] + nums[r];
                if(val >= target)
                    r--;
                else{
                    res+= r - l; //attention
                    l++;
                   
                }
            }
        }
        return res;
    }
}
