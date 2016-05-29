// a O(Nlogk) treeset code:
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


//////////////////////////////////////////////////////
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0 || k < 1) return false;
        //bucket is used to check a range!!(map)
        Map<Long,Long>map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            long dist = (long)nums[i] -Integer.MIN_VALUE;
            long bucket = dist/((long)t + 1);
            if(map.containsKey(bucket) || map.containsKey(bucket-1) && dist <= map.get(bucket-1)+t ||
             map.containsKey(bucket+1) && dist >= map.get(bucket+1) -t )
                return true;
            if(map.size()>=k){
                long no =( (long)nums[i-k] -Integer.MIN_VALUE)/((long)t + 1);
                map.remove(no);
            }
            map.put(bucket,dist);
        }
        return false;
    }
}
