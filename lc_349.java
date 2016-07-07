public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set = new HashSet<>();
        Set<Integer>intersect = new HashSet<>();
        for(int num:nums1)
            set.add(num);
        for(int i = 0; i< nums2.length;i++){
            if(set.contains(nums2[i]))
                intersect.add(nums2[i]);
        }
        int i = 0;
        int []res = new int[intersect.size()];
        for(int num:intersect){
            res[i++] = num;
        }
        return res;
    }
}
