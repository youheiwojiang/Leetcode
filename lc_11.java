public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1,area = 0;
        while(l < r){
            area = Math.max(Math.min(height[l],height[r])*(r - l),area);
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return area;
    }
}
