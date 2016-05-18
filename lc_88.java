public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n-1;
        for(int i = len;i>=0;i--){
            if(m >0 && n>0){
                if(nums1[m-1] > nums2[n-1]) nums1[len--] = nums1[--m];
                else nums1[len--] = nums2[--n];
            }else if(m > 0) // this can be omitted
            nums1[len--] = nums1[--m];
            else
            nums1[len--] = nums2[--n];
        }
        return ;
    }
}
