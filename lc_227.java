public class Solution {
    public int calculate(String s) {
        int len = s.length(),res = 0;
        if(s == null || s.length() == 0) return 0;
        Stack<Integer>ss = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0 ;i<len ;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10*num + c -'0';
            } 
            if(!Character.isDigit(c) && c != ' ' || i == len-1){
                if(sign == '+') ss.push(num);
                if(sign =='-') ss.push(-num);
                if(sign == '*') ss.push(ss.pop()*num);
                if(sign == '/') ss.push(ss.pop()/num);
                sign = c;
                num = 0;
            }
        }
        for(int number:ss)
        res += number;
        return res;
    }
}
