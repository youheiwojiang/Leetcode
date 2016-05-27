public class Solution {
    public int findKthLargest(int[] nums, int k) {
      k = nums.length - k;
      int lo = 0, hi = nums.length -1;
      while(lo < hi){
          int index = partition(nums,lo,hi);
          if(index == k) break;
          else if(index < k){
             lo = index + 1;
          }else
            hi = index-1;
      }
      return nums[k];
    }
    private int partition(int[]nums, int lo, int hi){
        int i = lo+1,j = hi;//can't handle one element
        while(true){
            while(nums[i] < nums[lo] && i<hi) i++;
            while(nums[j] > nums[lo] && j>lo) j--;
            if(i >= j) break;
            swap(nums,i,j);
            i++;j--;
        }
        swap(nums,lo,j);
        return j;
    }
    private void swap(int[]nums,int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
        return;
    }
}
