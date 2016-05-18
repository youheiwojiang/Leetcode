public class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        help(nums,new ArrayList<>(), -1);
        return res;
    }
    public void help(int[] nums, List<Integer>list,int pos){
        res.add(list);
        for(int i = pos+1;i<nums.length;i++){
            if(i> pos+1 && nums[i] == nums[i-1]) continue;//typical ways to handle duplicate in backtrackign
            List<Integer>newlist = new ArrayList<>(list);
            newlist.add(nums[i]);
            help(nums,newlist,i);
            
        }
        return ;
    }
}
