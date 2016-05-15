  public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>res = new ArrayList<>();
        if(matrix.length ==0)
            return res;
        int x1 = matrix.length-1,y1 = matrix[0].length-1;
        int x0 = 0, y0 = 0;
        int x = 0,y = 0;
        //use four bounds to concise the code
        while(x0 < x1 && y0 < y1){
              x = x0;y = y0;
              while(y < y1){res.add(matrix[x][y++]);}
              while(x < x1){res.add(matrix[x++][y]);}
              while(y > y0){res.add(matrix[x][y--]);}
              while(x >x0){res.add(matrix[x--][y]);}
              x0++;y0++;x1--;y1--;
        }
        x = x0; y = y0;
        // handle the one line or one column case
        if(x0 == x1 ){
            while(y <= y1) res.add(matrix[x][y++]);
        }else if( y0== y1 ){
            while(x <= x1) res.add(matrix[x++][y]);
        }
        return res;
    }
}
