//needs reconsider a better comprenhensive way!!
//equals to adding a new 0 height entry in heights and clean all the elements in
//stack also it's O(n) because each one comes in once and pop once
public class Solution {
    public int largestRectangleArea(int[] heights) {
        //use stack to maintain the last smaller pos than the cur;
        Stack<Integer>stack = new Stack<>();
        int max = 0;
        for(int i = 0; i<=heights.length;i++){
            int h = (i==heights.length?0:heights[i]);
            if(stack.isEmpty() || heights[stack.peek()] <= h){
                stack.push(i);
            }else{
                int tp = stack.pop();
                max= Math.max(max,heights[tp]*(stack.isEmpty()?i:i-stack.peek()-1) );//attention
                i--; // still process the current one
            }
            
            
        }
        return max;
    }
}
/////////////////////////////////////////////////////////////////////////////////

