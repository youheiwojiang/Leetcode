public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length<1) return 0;
        Stack<Integer>stack = new Stack<>();
        for(String token:tokens){
            if(token.equals("+") || token.equals("-")||token.equals("*")||token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int c = 0;
                if(token.equals("+")) c= a+b;
                else if(token.equals("-")) c= a-b;
                else if(token.equals("*")) c= a*b;
                else  c= a/b;
                stack.push(c);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
