public class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        char[] dict = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<8 ;i++){
            int count = 0;
            int base = 1;
            for(int j = 0; j< 4; j++){
                int bit = (num & 1);
                count += bit * base;
                base *= 2;
                num >>>= 1;
            }
            str.insert(0,dict[count]);
        }
        int i = 0;
        while(i < str.length() && str.charAt(i) == '0'){
            i++;
        }
        return str.toString().substring(i);
    }
}
