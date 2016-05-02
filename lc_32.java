public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>stack = new Stack<>();
        int max = 0;
        for(int i = 0; i< s.length();i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else
                    stack.push(i);
            }
        }
        if(stack.isEmpty())
            return s.length();
        int l = 0 ,r = s.length();
        while(!stack.isEmpty()){
            l = stack.pop();
            max = Math.max(max,r-l-1);
            r = l;
        }
        max = Math.max(max,l);
        return max;
    }
}
////////////////////////////////////////////////////////////
//classical dp solution:
public class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()<2)
            return 0;
        int []longest = new int[s.length()];
        int max = 0;
        for(int i = 1 ;i< s.length();i++){
            if(s.charAt(i) == '(')
                longest[i] = 0;
            else{
                if(s.charAt(i-1) == '(')
                    longest[i] = (i>=2?longest[i-2]:0)+2;
                else{ 
                if(i-1-longest[i-1] >=0 && s.charAt(i-1-longest[i-1]) == '(' )
                // 括号要包含所有的三元表达式(?,:)
                        longest[i] = 2 + longest[i-1] + (i-2-longest[i-1]>=0?longest[i-2-longest[i-1]]:0);
                }
            }
            max = Math.max(longest[i],max);
        }
        return max;
    }
}
