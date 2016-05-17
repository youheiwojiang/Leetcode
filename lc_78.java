public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>>res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int num = 1<<len ;
        for(int i = 0; i< num;i++){
            List<Integer>list = new ArrayList<>();
            for(int j=0;j<len;j++){
                if((i & (1<<j)) != 0 )//note the order it addes num
                    list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }
}
