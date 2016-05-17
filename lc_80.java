public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num:nums){
            if(i < 2 || num > nums[i-2])
                nums[i++] = num;
        }
        return i;
    }
}
// a more general way
int removeDuplicates(int A[], int n, int k) {

            if (n <= k) return n;

            int i = 1, j = 1;
            int cnt = 1;
            while (j < n) {
                if (A[j] != A[j-1]) {
                    cnt = 1;
                    A[i++] = A[j];
                }
                else {
                    if (cnt < k) {
                        A[i++] = A[j];
                        cnt++;
                    }
                }
                ++j;
            }
            return i;
}
