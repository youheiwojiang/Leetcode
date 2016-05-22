public class Solution {
    public boolean isPalindrome(String s) {
      s = s.trim().toLowerCase();
      int l =0,r = s.length()-1;
      while(l < r){
          while(l < r && !Character.isLetterOrDigit(s.charAt(r)))
            r--;
          while(l < r && !Character.isLetterOrDigit(s.charAt(l)))
            l++;
          if(l < r && s.charAt(r) != s.charAt(l))   return false;
          l++;
          r--;
      }
      return true;
    }
}
