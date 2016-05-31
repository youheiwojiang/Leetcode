public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer>s = new Stack<>();
        for(int val:preorder){
            if(val < low) //low denote the poping root node all node < it shouldn't appear
                return false;
            while(!s.isEmpty() && s.peek() < val)
                low = s.pop();
            s.push(val);
        }
        return true;
    }
}
