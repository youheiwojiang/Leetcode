  public class Solution {
    public int jump(int[] nums) {
        //int end = nums.length-1;
        int last_max = 0, cur_max = 0,steps = 0;
        for(int i =0 ;i< nums.length -1 ;i++ ){
            cur_max = Math.max(cur_max, i+nums[i]);
            if(i == last_max){
                steps++;
                last_max = cur_max;//update when reach the max pos using current steps
            }
        }
        return steps;
    }
}
