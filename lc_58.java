 public class Solution {
    public int lengthOfLastWord(String s) {
        /*
        int last = 0, count = 0;
        for(int i = 0 ; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                count = 0;
            }else{
                count++;
            }
            last = count ==0?last:count;
        }
        return last;
        */
        return s.trim().length() - s.trim().lastIndexOf(" ")-1;
    }
}
