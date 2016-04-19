public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res= new ArrayList<List<Integer>>();
        int pred = 0;
        for(int i = 0; i<nums.length-2;i++){
            //
            if(i > 0 && nums[i] == pred)
                continue;
            pred = nums[i];
            int l = i+1,r = nums.length-1;
            while(l < r){
                int sum = nums[l] + nums[i] + nums[r];
                if(sum < 0){
                    l++;
                }else if(sum > 0){
                    r--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(nums[r] == nums[r-1] && r > l)
                         r--;
                    while(nums[l] == nums[l+1] && l < r)
                         l++;
                    // easy to forget the two clause
                    r--;
                    l++;
                }
            }
        }
        return res;
    }
}
