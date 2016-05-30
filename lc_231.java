public class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        if(n < 0) return false; //key part
        for(int i = 0;i < 31;i++){
            count+= ((n & 1)  != 0)?1:0;
            n >>= 1;
        }
        return count == 1;
    }
}
