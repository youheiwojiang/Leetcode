//an genious DP method:
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length,n = matrix[0].length;
        int max =0 ;
        int left[] = new int[n],right[] = new int[n],height[] = new int[n];
        for(int i = 0; i< n;i++)
            right[i] = n;
        for(int i = 0; i< m; i++){
            int cur_left = 0,cur_right = n;
            for(int j = 0; j<n;j++){
                height[j] = (matrix[i][j] =='0'?0:height[j]+1);
            }
            for(int j=0; j<n; j++) { // compute left (from left to right)
                if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur_left);
                else {left[j]=0; cur_left=j+1;}
             }
             for(int j=n-1; j>=0; j--) {
                if(matrix[i][j]=='1') right[j]=Math.min(right[j],cur_right);
                 else {right[j]=n; cur_right=j;}    
             }
            for(int j=0; j<n; j++)
            max = Math.max(max,(right[j]-left[j])*height[j]);
        }
        return max;
    }
}
/////////////
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length ==0)
            return 0;
        int m = matrix.length,n = matrix[0].length;
        int h[] = new int[n+1];
        h[n] = 0;
        int max  = 0;
        for(int i = 0; i< m; i++){
            Stack<Integer>s = new Stack<>();
            for(int j = 0; j <= n; j++){
                if(j < n){
                    if(matrix[i][j] =='1')
                        h[j]++;
                    else
                        h[j] = 0;
                }
                if(s.isEmpty()||h[j] >= h[s.peek()]){
                    s.push(j);
                }else{
                    while(!s.isEmpty() && h[j] < h[s.peek()]){//note h[s.peek()] not s.peek()
                        int tmp = s.pop();
                        int area = h[tmp] * (s.isEmpty()?j:(j-s.peek()-1));
                        max = Math.max(max,area);
                    }
                    s.push(j);
                }
            }
        }
        return max;
        
    }
}
