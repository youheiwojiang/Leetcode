public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int []bucketmin = new int[nums.length];
        int []bucketmax = new int[nums.length];
        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        if(min == max) return 0;
        Arrays.fill(bucketmin, Integer.MAX_VALUE);
        Arrays.fill(bucketmax, Integer.MIN_VALUE);
        int gap = (int)Math.ceil((double)(max - min)/(nums.length -1));
        for(int num:nums){
            //if(num == min || num == max) continue;//handles the duplicate condition(min == max)
            int index = (num - min )/ gap;
            bucketmin[index] = Math.min(bucketmin[index],num);
            bucketmax[index] = Math.max(bucketmax[index],num);
        }
        int maxGap = Integer.MIN_VALUE;
        int prev = min;
        for(int i = 0; i< nums.length; i++){
            if(bucketmin[i] == Integer.MAX_VALUE || bucketmax[i] == Integer.MIN_VALUE) continue;//bucket is empty;
            maxGap = Math.max(maxGap,bucketmin[i] - prev);
            prev = bucketmax[i];
        }
        maxGap = Math.max(maxGap,max - prev);
        return maxGap;
    }
}
