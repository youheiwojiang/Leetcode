//my version:
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int l = 0,r = matrix.length-1,mid = 0;
        while(l<r){
            mid = r- (r-l)/2;
            if(matrix[mid][0] <= target)
                l = mid;
            else
                r = mid -1;
        }
        int col = l;
        l = 0 ; r = matrix[0].length-1;
        while(l <= r){
            mid = l+(r-l)/2;
            if(matrix[col][mid] == target)
                return true;
            else if(matrix[col][mid] < target)
                l++;
            else
                r--;
        }
        return false;
    }
}
//////////////////////////////////////////////////////////////////////////
public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int start = 0, rows = matrix.length, cols = matrix[0].length;
            int end = rows * cols - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[mid / cols][mid % cols] == target) {
                    return true;
                } 
                if (matrix[mid / cols][mid % cols] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }
