public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0) return;
        int m = board.length,n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0; j< n; j++){
                int life = lives(board,i,j,m,n);
                if(board[i][j] == 1 && life >=2 && life <= 3)
                    board[i][j] = 3;
                else if(board[i][j] == 0 && life == 3)
                    board[i][j] = 2;
            }
        }
        for(int i = 0; i<m;i++){
            for(int j = 0;j<n;j++)
                board[i][j] >>= 1;
        }
        return;
    }
    
    private int lives(int [][]board, int i ,int j ,int m, int n){
        int lives = 0;
        for(int a = Math.max(i-1,0);a<=Math.min(m-1,i+1);a++)
            for(int b = Math.max(j-1,0);b<=Math.min(n-1,j+1);b++)
                lives += (board[a][b]&1);
        lives-=(board[i][j] &1);
        return lives;
    }
}
