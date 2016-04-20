
public class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        for(int i = 0 ; i< s.length();i++){
            char cur =s.charAt(i);
            if(cur == '(' || cur =='[' || cur == '{')
                stack.push(cur);
            else if(cur == ')' && !stack.isEmpty() &&stack.peek() == '(')
                stack.pop();
            else if(cur == ']' && !stack.isEmpty() &&stack.peek() == '[')
                stack.pop();
            else if(cur == '}' && !stack.isEmpty() &&stack.peek() == '{')
                stack.pop();
            // notice it only works for no other strings like abcdefg
            else
                return false;
        }
        return stack.isEmpty();
    }
}
