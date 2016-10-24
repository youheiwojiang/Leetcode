public class Solution {
    int lo,maxlen;
    public String longestPalindrome(String s) {
        for(int i = 0; i<s.length(); i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(lo,lo+maxlen);
    }
    private void expand(String s, int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;r++;
        }
        if(r-l-1 > maxlen){
            maxlen = r-l-1;
            lo = l+1;
        }
        return ;
    }
}
