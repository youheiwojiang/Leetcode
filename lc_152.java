public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int maxherepre = nums[0],minherepre = nums[0],maxsofar = nums[0];
        int maxhere = 0,minhere = 0;
        for(int i = 1; i< nums.length;i++){
            maxhere = Math.max(nums[i],Math.max(maxherepre*nums[i],minherepre*nums[i]));
            minhere = Math.min(nums[i],Math.min(minherepre*nums[i],maxherepre*nums[i]));
            maxsofar = Math.max(maxsofar,maxhere);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }
}
