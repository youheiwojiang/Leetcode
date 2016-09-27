public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int check[] = new int[256];
        for(int i = 0 ; i< magazine.length(); i++){
            check[magazine.charAt(i)]++;
        }
        for(int i = 0; i< ransomNote.length();i++){
            if(--check[ransomNote.charAt(i)]<0)
                return false;
        }
        return true;
    }
}
