public class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for(int num :nums)
            res ^= num;     // a ^ b 
        res = (-res & res);
        int a = 0,b = 0;
        for(int num :nums){
            if((num & res) == 0)
                a ^= num;
            else
                b ^= num;
        }
        int arr[] = new int[2];
        arr[0] = a;arr[1] = b;
        return arr;
    }
}
