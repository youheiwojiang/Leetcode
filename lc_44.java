  public class Solution {
    public boolean isMatch(String s, String p) {
        // recursion or no recursion
        //this will TLE
        /*
        if(p.length() == 0)
            return s.length() == 0;
        if(s.length() == 0)
            return p.length()>0 && (p.charAt(0) == '?'||p.charAt(0)=='*') && isMatch(s,p.substring(1));
         if(p.charAt(0) == '?')
            return isMatch(s.substring(1),p.substring(1));
         if(p.charAt(0) == '*')
            return   p.length()>1 && p.charAt(1) == s.charAt(0) && isMatch(s.substring(1),p.substring(1))||isMatch(s.substring(1),p);
         return s.charAt(0) == p.charAt(0) && isMatch(s.substring(1),p.substring(1));
         */
         /////////////////////////////////////////////////////////////////////////////
         int ss = 0, pp = 0,laststar = -1,match = 0;
         while(ss < s.length()){
             if(pp< p.length() && (p.charAt(pp) == '?'|| s.charAt(ss) == p.charAt(pp))){//first choose not to use *
                pp++;
                ss++;
             }
             else if(pp < p.length() && p.charAt(pp) == '*'){
                 laststar = pp ;
                 pp++;
                 match = ss;//label the first pos need * to handle
             }
             else if(laststar!=-1){
                 // above if can't handle need * to handle all the last match to the cur;   
                 pp = laststar + 1;
                 match++;
                 ss = match; //update the match as the last pos need * to handle
             }
             else return false;
         }
         while(pp < p.length() && (p.charAt(pp) == '*')) pp++;//? can't match empty
         return pp == p.length();
    }
}
