//my DP code store the last value of diff LIS
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int res[] = new int[len+1];
        for(int i = 0; i<=len; i++) res[i] = Integer.MAX_VALUE;
        res[0] = Integer.MIN_VALUE;
        for(int i = 0; i< len ;i++){
            for(int j = i;j >=0; j--){
                if(nums[i] > res[j] && res[j+1] > nums[i])
                    res[j+1] = nums[i];
            }
        }
        for(int i = len ;i>=0; i--){
            if(res[i]!=Integer.MAX_VALUE)
                return i;
        }
        return 0;
    }
}
////////////////////////////////////////////////////////
//more concise code of DP store the len 
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 1 ) return 0;
        int T[] = new int[nums.length];
        for(int i = 0; i< nums.length;i++) T[i] = 1;
        for(int i = 1; i< nums.length; i++){
            for(int j = 0; j< i; j++){
                if(nums[j] < nums[i]){
                    T[i] = Math.max(T[i],T[j]+1);
                }
            }
        }
        int len = 1;
        for(int num:T){
            len = Math.max(len,num);
        }return len;
    }
}
///////////////////////////////////////////////////////////
//another b-search code
public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);//note if not get will return a negative num according to its order(index) -index-1
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
