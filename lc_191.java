public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i = 1;
        int count = 0;
        for(int j = 0; j< 32;j++){
            if((n&i)!=0) count++;
            i = (i<<1);
        }
        return count;
    }
}
