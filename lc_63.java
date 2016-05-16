public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null ||obstacleGrid.length ==0 )
            return 0;
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        //int dp[][]= new int[m][n];
        int cur[] = new int[n];
        boolean foundone = false;
        for(int i = 0; i<n && !foundone ;i++){
           if(obstacleGrid[0][i] == 1) {
               foundone = true;
           }else
                cur[i] = 1;
        }
        for(int i = 1; i< m;i++){
            if(obstacleGrid[i][0] == 1)//
                cur[0] = 0;// need attention
            for(int j = 1; j< n; j++){
                if(obstacleGrid[i][j] == 0)
                    cur[j]+= cur[j-1];
                else
                    cur[j] = 0;
            }
        }
        return cur[n-1];
        
    }
}
