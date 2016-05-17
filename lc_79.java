//good version to compare and consider the style of dfs
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        int m = board.length,n = board[0].length;
        //boolean res = false;
        boolean [][]visit = new boolean[m][n];
        for(int x = 0; x<m;x++){
            for(int y =0; y<n;y++){
                if(board[x][y] == word.charAt(0) && help(board,word,0,x,y,visit)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean help(char[][]board, String word, int pos,int x, int y,boolean[][]visit){
        if(pos == word.length())
            return true;
        if(x > board.length-1 || x<0 || y<0 ||y>board[0].length-1 || board[x][y] != word.charAt(pos) || visit[x][y])//do check before dfs is better
            return false;
        visit[x][y] = true;
        if(help(board,word,pos+1,x-1,y,visit) ||
            help(board,word,pos+1,x+1,y,visit) ||
            help(board,word,pos+1,x,1+y,visit) ||
            help(board,word,pos+1,x,y-1,visit))
            return true;
        visit[x][y] = false;
        return false;
    }
}



//It's my tle version
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        int m = board.length,n = board[0].length;
        boolean res = false;
        boolean [][]visit = new boolean[m][n];
        for(int x = 0; x<m;x++){
            for(int y =0; y<n;y++){
                if(board[x][y] == word.charAt(0)){
                    res |= help(board,word,0,x,y,visit);
                    if(res)
                        return res;
                }
            }
        }
        return false;
    }
    boolean help(char[][]board, String word, int pos,int x, int y,boolean[][]visit){
        if(pos == word.length() -1 )
            return true;
        boolean result = false;
        if(x>0 && !visit[x-1][y] && board[x-1][y] == word.charAt(pos+1)){
            visit[x-1][y] = true;
            result |= help(board,word,pos+1,x-1,y,visit);
            visit[x-1][y] = false;
        }
         if(y>0 && !visit[x][y-1]&&board[x][y-1] == word.charAt(pos+1)){
            visit[x][y-1] = true;
            result |= help(board,word,pos+1,x,y-1,visit);
            visit[x][y-1] = false;
        }
         if(x<board.length-1 && !visit[x+1][y]&&board[x+1][y] == word.charAt(pos+1)){
            visit[x+1][y] = true;
            result |= help(board,word,pos+1,x+1,y,visit);
            visit[x+1][y] = false;
        }
         if(y<board[0].length-1 && !visit[x][y+1]&&board[x][y+1] == word.charAt(pos+1)){
            visit[x][1+y] = true;
            result |= help(board,word,pos+1,x,y+1,visit);
            visit[x][1+y] = false;
        }
        
        return result;
    }
}
