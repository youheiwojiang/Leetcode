public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int row = board.length, col = board[0].length;
        for(int i = 0; i< row; i++){
            if(board[i][0] == 'O')
                check(board,i,0);
            if(board[i][col-1] == 'O')
                check(board,i,col-1);
        }
        for(int j = 0;j < col ;j++){
            if(board[0][j] == 'O')
                check(board,0,j);
            if(board[row-1][j] == 'O')
                check(board,row-1,j);
        }
        for(int i = 0; i< row;i ++)
            for(int j = 0; j< col; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '1')
                    board[i][j] = 'O';
            }
    }
    private void check(char[][]board, int i ,int j){ // reduce the time of recursion to avoid stackoverflow
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
        return;
    if (board[i][j] == 'O')
        board[i][j] = '1';
    if (i > 1 && board[i-1][j] == 'O')
        check(board, i-1, j);
    if (i < board.length - 2 && board[i+1][j] == 'O')
        check(board, i+1, j);
    if (j > 1 && board[i][j-1] == 'O')
        check(board, i, j-1);
    if (j < board[i].length - 2 && board[i][j+1] == 'O' )
        check(board, i, j+1);
    }
}
