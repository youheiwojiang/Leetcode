public class Solution {
    public int calculate(String s) {
        Stack<Integer>ss = new Stack<>();
        int num = 0;
        int res = 0;
        int sign = 1;
        for(int i = 0; i< s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10*num+c-'0';
            }else if(c == '+'){
                res+= num*sign;
                num = 0;
                sign = 1;
            }else if(c =='-'){
                
                res+= num*sign;
                num = 0;
                sign = -1;
            }else if(c=='('){
                ss.push(res);
                ss.push(sign);
                res = 0; //attention
                sign = 1; // attention
            }else if(c== ')'){
                  res+= sign*num;
                  num = 0;
                  int presign = ss.pop();
                  int preval = ss.pop();
                  res = preval + presign*res;
            }
        }
        if(num != 0) res+= sign * num;
        return res;
    }
}
