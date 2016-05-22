public class Solution {
    public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE,s1 = 0, b2 = Integer.MIN_VALUE, s2 = 0;
        for(int i = 0; i< prices.length; i++){
            s2 = Math.max(b2 + prices[i] , s2);
            b2 = Math.max(b2,s1 - prices[i]);
            s1 = Math.max(s1, b1 + prices[i]);
            b1 = Math.max(b1, -prices[i]);
        }
        return s2;
    }
}
