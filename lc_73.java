public class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        if(matrix == null || matrix.length == 0)
            return;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i< m ;i++){
            if(matrix[i][0] == 0)
                col0 = 0;
            for(int j = 1; j <n ;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // this can be improve by reverse make i start from m-1!
        // also attention the order of the following code!
        for(int i = 1; i< m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][0] == 0|| matrix[0][j] ==0)
                    matrix[i][j] = 0;
             }
        } 
       
        if(matrix[0][0] == 0)
        for(int j = 1; j<n;j++) matrix[0][j] = 0;
         if(col0 == 0)
        for(int i = 0; i< m; i++) matrix[i][0] = 0;
        return;
    }
}
