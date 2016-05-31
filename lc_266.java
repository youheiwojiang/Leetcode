public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[]table = new int[256];
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(table[c] == 1 ) table[c]--;
            else table[c]++;
        }
        int count = 0;
        for(int i = 0; i<256;i++)
            count+= table[i]!=0?1:0;
        return count <=1;
    }
}
