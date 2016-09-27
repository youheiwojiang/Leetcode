public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer,Integer>map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num))
                map.put(num,0);
            map.put(num,map.get(num) + 1);
        }
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<Integer>();
            bucket[freq].add(key);  
        }
        for(int i = nums.length; i>0 && res.size() <k ; i--){
            if(bucket[i]!= null)
                res.addAll(bucket[i]);
        }
        return res;
    }
}
