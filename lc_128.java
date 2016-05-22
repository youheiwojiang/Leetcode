public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>set = new HashSet<>();
        int max = 1;
        int len = 1;
        for(int num:nums) set.add(num);
        for(int num:nums){
            if(!set.contains(num)) continue;
            len = 1;
            int tmp = num;
            set.remove(num);
            while(set.contains(++num)){
                set.remove(num);
                len++;
            }
            while(set.contains(--tmp)) {
                len++;
                set.remove(tmp);
            }
            max = Math.max(max,len);
        }
        return max;
    }
}
