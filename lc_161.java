public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()) return isOneModify(s,t);
        else if(s.length() > t.length())return isOneDel(s,t);
        else return isOneDel(t,s);
        
    }
    private boolean isOneDel(String s, String t){ // len(s) > len(t)
        for(int i = 0; i<Math.min(s.length(),t.length());i++){
            if(s.charAt(i)!=t.charAt(i))
                return s.substring(i+1).equals(t.substring(i));
        }
        //return true;
       return s.length() == t.length() + 1;
    }
    private boolean isOneModify(String s, String t){
        for(int i = 0; i< s.length();i++){
            if(s.charAt(i) != t.charAt(i))
                return s.substring(i+1).equals(t.substring(i+1));
        }
        return false;
    }
}
