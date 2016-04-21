
public class Solution {
    public int divide(int dividend, int divisor) {
        //remember to use bit shift
        if(dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0)
            return Integer.MAX_VALUE;
        //if(divisor == 1)
          //  return dividend;
        int sign = ((dividend < 0) ^ (divisor< 0))?-1:1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int res = 0;
        while(dvd >= dvs){
            long tmp = dvs;
            int mul = 1;
            //remember << and >>> >> are right combination ,your target is on the left
            // tmp <<1 means tmp * 2, a<<b means a*2^b
            while(dvd >= (tmp<<1)){
                tmp <<= 1;
                mul <<= 1;
            }
            dvd -= tmp;
            res+= mul;
            
        }
        return sign==1?res:-res;
    }
}

