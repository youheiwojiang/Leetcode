public class Solution {
    public int findNthDigit(int n) {
        int bit = 1;
        long count = 9;
        int start = 1;
        while(n > bit * count ){
            n -= bit * count;
            count *= 10;
            start *= 10;
            bit += 1;
        }
        start += (n -1)/bit; //get the right num
        String s = Integer.toString(start);
        return (s.charAt((n-1)%bit) - '0');
    }
}
