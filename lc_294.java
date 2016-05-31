public class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        for(int i = 0; i< s.length()-1;i++){
            if(s.substring(i,i+2).equals("++")){
                String next = s.substring(0,i)+"--"+s.substring(i+2);
                if(!canWin(next)) return true;
            }
        }
        return false;
    }
}
