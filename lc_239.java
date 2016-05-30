//my O(Nlogk) code:
//public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k <=0) return new int[0];
        int res[] = new int[nums.length - k + 1];
        TreeMap<Integer,Integer>map = new TreeMap<>();
        for(int i = 0; i<= nums.length; i++){
            if(i >= k ){
                res[i-k] = map.lastKey();
                map.put(nums[i-k],map.get(nums[i-k])-1);
                if(map.get(nums[i-k]) == 0) map.remove(nums[i-k]);
            }
            if(i < nums.length){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
            }
        }
        return res;
    }
}

///////////////////////////////////////////////////////
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <=0) return new int[0];
        int res[] = new int[nums.length - k + 1];
        Deque<Integer>q = new ArrayDeque<>();
        for(int i = 0;i<nums.length;i++){
            while(!q.isEmpty() && q.peek()<i-k+1)
                q.poll();
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            q.offer(i);
            if(i>=k-1)
                res[i-k+1] = nums[q.peek()];
        }
        return res;
    }
}
