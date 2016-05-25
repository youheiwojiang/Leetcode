public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String>res = new LinkedList<>();
        int start = lower;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] < lower || nums[i] > upper) continue;
            if(nums[i] == start) start++;
            else{
                if(nums[i] == start + 1) {
                    res.add(String.valueOf(start));
                   
                }
                else {
                    StringBuilder str = new StringBuilder();
                    str.append(start).append("->").append(nums[i]-1);
                    res.add(str.toString());
                } 
                start = nums[i] + 1;
            }
        }
        if(start <= upper){
            if(start == upper) res.add(String.valueOf(start));
            else {
                    StringBuilder str = new StringBuilder();
                    str.append(start).append("->").append(upper);
                    res.add(str.toString());
                } 
        }
        return res;
    }
}
