  public class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int x0 = 0,y0= 0,x1 = n-1,y1 = n-1;
        int x =0,y =0;
        int index = 1;
        while(x0 < x1 && y0 < y1){
            x = x0;y = y0;
            while(y < y1) matrix[x][y++] = index++;
            while(x < x1) matrix[x++][y] = index++;
            while(y > y0) matrix[x][y--] = index++;
            while(x > x0) matrix[x--][y] = index++;
            x0++;y0++;x1--;y1--;
        }
        x = x0;y=y0;
        if(x0 == x1){
            while(y <= y1)
                matrix[x0][y++] = index++;
        }else if(y0 == y1){
            while(x <= x1)
                matrix[x++][y0] = index++;
        }
        return matrix;
    }
}
