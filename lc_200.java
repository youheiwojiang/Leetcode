public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        int row = grid.length,col = grid[0].length,count = 0;
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col;j++){
                if(grid[i][j] == '1' && !visit[i][j]){
                    dfs(grid,visit,i,j,row,col);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][]grid, boolean[][]visit, int i, int j,int row,int col){
        if(i<0 || i==row || j< 0 ||j==col || grid[i][j]!= '1' || visit[i][j])
            return;
        visit[i][j] = true;
        dfs(grid,visit,i,j+1,row,col);    
         dfs(grid,visit,i,j-1,row,col); 
          dfs(grid,visit,i+1,j,row,col); 
           dfs(grid,visit,i-1,j,row,col); 
        
        
    }
}
