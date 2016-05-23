public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;//use two bit to denote each bit(00->10->01->00...)
        for(int num:nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
