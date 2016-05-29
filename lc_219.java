public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
            else{
                if(i <= k+ map.get(nums[i])) return true;
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
