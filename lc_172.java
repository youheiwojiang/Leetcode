public class Solution {
    public int trailingZeroes(int n) {
        int num = 0;
        int sign = 1;
        while(n != 0){
            num +=sign*n/5;
            n = n/5;
            //sign = -sign;
        }
        return num;
    }
}
