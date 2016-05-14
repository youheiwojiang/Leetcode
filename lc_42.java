  public class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length -1,maxleft = 0 , maxright = 0, res = 0;
        //check each 1-width column one by one keep track of one-side wall
        //remember this method works for some similar prob use two side relations to eliminate one side
        while( l <= r){
            if(height[l] <= height[r]){
                if(height[l] >= maxleft)
                    maxleft = height[l];
                else
                    res += maxleft - height[l];
                l++;
            }else{
                if(height[r] >= maxright)
                    maxright = height[r];
                else
                    res+= maxright - height[r];
                r--;
            }
        }
     return res;  
    }
}
