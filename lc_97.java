public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(),n = s2.length(),p = s3.length();
        if(m + n != p) return false;
         boolean[][] check = new boolean[m+1][n+1];
        for(int i = 0; i<=m ;i++){
            for(int j = 0;j<=n;j++){//check[i][j] means s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at jth position. 0th position means empty string.
                if(i == 0 && j == 0) check[i][j] = true;
                else if(i ==0){
                    check[i][j]  = check[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }else if(j == 0)
                     check[i][j]  = check[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                else{
                    check[i][j] = check[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1) || check[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) ;
                }
            }
        }
        return check[m][n];
        
           
    }
}
