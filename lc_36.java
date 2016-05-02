  public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<9;i++){
            if(!isValid(board,i,0,i,8) || !isValid(board,0,i,8,i))
                return false;
        }
        for(int i = 0;i<8;i+=3){
            for(int j = 0;j<8;j+=3){
                if(!isValid(board,i,j,i+2,j+2))
                    return false;
            }
        }
        return true;
    }
    public boolean isValid(char[][]board,int lx, int ly,int rx, int ry){
        Set<Character>set = new HashSet<>();
        for(int i = lx; i<=rx; i++){
            for(int j = ly;j<=ry;j++){
                if(board[i][j] == '.')
                    continue;
                if(!set.add(board[i][j]))
                    return false;
            }
        }
        return true;
    }
}
