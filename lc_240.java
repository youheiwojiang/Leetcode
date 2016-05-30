public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int col = matrix[0].length-1,row = 0;
        while(col >-1 && row <  matrix.length){
            if(matrix[row][col] == target)
                    return true;            
            if(matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
}
