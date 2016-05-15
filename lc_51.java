  public class Solution {
    List<List<String>>res= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char matrix[][] = new char[n][n];
        for(int i = 0; i< n;i++){
            for(int j = 0; j< n;j++)
                matrix[i][j] = '.';
        }
       dfs(matrix,0,0);
       return res;
    }
    public boolean dfs(char[][] matrix, int num, int x){
        if(num == matrix.length){
            List<String>cur= new ArrayList<>();
            for(char[] array : matrix){
                cur.add(String.valueOf(array));
            }
            res.add(cur);
            return true;
        }
        for(int i = x;i < matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                if( check(matrix,i,j)){
                    matrix[i][j] = 'Q';
                    dfs(matrix,num+1,i+1);
                    matrix[i][j] = '.';
                }
            }return false;
        }
        
        return false;
    }
    public boolean check(char[][]matrix, int x, int y){
        for(int i = 0; i<matrix.length; i++){
            if(matrix[i][y] == 'Q')
                return false;
        }
        int tx = x,ty = y;
        while(tx >=0 && ty >=0 ){
            if(matrix[tx--][ty--] == 'Q') return false;
        }
        for(int i = Math.max(0,x+y-matrix.length+1); i < x; i++){
            if(matrix[i][x+y-i] == 'Q') return false;
        }
        return true;
        
    }
}
