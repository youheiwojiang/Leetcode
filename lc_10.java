c class Solution {
    // a classical dp way to handle this
    /**
         * f[i][j]: if s[0..i-1] matches p[0..j-1]
         * if p[j - 1] != '*'
         *      f[i][j] = f[i - 1][j - 1] && s[i - 1] == p[j - 1]
         * if p[j - 1] == '*', denote p[j - 2] with x
         *      f[i][j] is true iff any of the following is true
         *      1) "x*" repeats 0 time and matches empty: f[i][j - 2]
         *      2) "x*" repeats >= 1 times and matches "x*x": s[i - 1] == x && f[i - 1][j]
         * '.' matches any single character
         */
    public boolean isMatch(String s, String p) {
        boolean check[][] = new boolean[s.length()+1][p.length()+1];
        check[0][0] = true;
        for(int i = 2 ; i<=p.length();i+=2){
            if(p.charAt(i-1) == '*')
                check[0][i] = check[0][i-2];
        }
        for(int i= 1; i<=s.length();i+=1){
            for(int j = 1; j<=p.length();j+=1){
                // two conditions accordint to whether current pos in j-1 is '*'
                if(p.charAt(j-1) != '*')
                check[i][j] = (s.charAt(i-1) == p.charAt(j-1)||p.charAt(j-1) == '.')&&check[i-1][j-1];  
                else
                check[i][j] = check[i][j-2]||(s.charAt(i-1) == p.charAt(j-2)||p.charAt(j-2) == '.')&&check[i-1][j]  ;
                
            }
        }
        return check[s.length()][p.length()];
    }
}


/////////////////////////////////////////////////////////////////////////////
public class Solution {
    public boolean isMatch(String s, String p) {
        //if(s.isEmpty())
          //  return true;
        if(p.length() == 0)
            return s.isEmpty();
        if(p.length()>1 && p.charAt(1) == '*')
            return isMatch(s,p.substring(2)) ||!s.isEmpty()&&(s.charAt(0) == p.charAt(0)||p.charAt(0) == '.')&&isMatch(s.substring(1),p);
        //notice s.isEmpty()
        return !s.isEmpty()&&(s.charAt(0) == p.charAt(0)||p.charAt(0) == '.')&&isMatch(s.substring(1),p.substring(1));
    }
}
