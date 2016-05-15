 public class Solution {
    public boolean isAnagram(String s, String t) {
        int table[] = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i< s.length(); i++){
            table[s.charAt(i)-'a']++;
            table[t.charAt(i)-'a']--;
        }
        for(int num:table){
            if(num != 0)
                return false;
        }
        return true;
    }
}
