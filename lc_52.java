//very consice solution 
public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[]cols = new boolean[n];
        boolean[]diag1 = new boolean[2*n];
         boolean[]diag2 = new boolean[2*n];
         backtrack(0,cols,diag1,diag2,n);
         return count;
    }
    public void backtrack(int row, boolean[]cols, boolean[]diag1 ,boolean[]diag2, int n){
        if(row == n)
            count++;
        for(int col = 0; col < n; col++ ){
            int id1 = col + row;
            int id2 = col - row + n;
            if(cols[col] || diag1[id1] || diag2[id2]) continue;
            cols[col] = true; diag1[id1] = true;diag2[id2] = true;
            backtrack(row+1,cols,diag1,diag2,n);
            cols[col] = false; diag1[id1] = false;diag2[id2] = false;
        }
        
        return;
    }
}
