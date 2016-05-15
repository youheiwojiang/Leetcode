  public class Solution {
    public void rotate(int[][] matrix) {
        //(x,y) --> (y,n-1-x)
        //reverse column and mirror (x,y) --> (n-1-x,y) --> (y,n-1-x);
        int len = matrix.length;
        reverse(matrix);
        mirror(matrix);
        
    }
    public void mirror(int[][] matrix){
        for(int i =0 ; i< matrix.length; i++){
            for(int j = 0; j<=i;j++ ){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
    }
    public void reverse(int[][]matrix){
        for(int i = 0; i< matrix.length; i++){
           int l = 0, r = matrix.length-1;
           while(l < r){
               int tmp = matrix[l][i];
               matrix[l][i] = matrix[r][i];
               matrix[r][i] = tmp;
               l++;r--;
           }
        }
    }
}
