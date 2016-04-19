public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>>res = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      int pred1 = 0,pred2 = 0;
      for(int i = 0; i<nums.length-3;i++){
          if(i>0 && nums[i] == pred1)
                continue;
          // remember to change values to the two predecessors(pred1,pred2);
          pred1 = nums[i];
          for(int j = i+1;j<nums.length-2;j++){
              if(j>i+1 && nums[j] == pred2)
                 continue;
              pred2 = nums[j];
              int l = j+1,r = nums.length-1;
              while(l<r){
                  int sum = nums[i] + nums[j] + nums[l] + nums[r];
                  if(sum == target){
                      res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                      while(nums[r] == nums[r-1] && r > l)
                            r--;
                      while(nums[l] == nums[l+1] && l < r)
                            l++;
                      r--;
                      l++;
                  }else if(sum < target){
                      l++;
                  }else{
                      r--;
                  }
              }
          }
      }
      return res;
    }
}
