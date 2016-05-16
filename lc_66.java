public class Solution {
    public int[] plusOne(int[] digits) {
        int[]newdigits = new int[digits.length + 1];
        int carry = 1;
        for(int i = digits.length -1 ; i>=0 ;i--){
            int tmp = carry + digits[i];
            //newdigits[i] = tmp %10;
            carry = tmp/10;
            digits[i] = tmp %10;
        }
        if(carry == 1){
            newdigits[0] = 1;
            return newdigits;
        }return digits;
        
    }
}
