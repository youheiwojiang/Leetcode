public class Solution {
    List<List<String>>results = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(new ArrayList<String>(),s, 0);
        return results;
    }
    private void backTrack(List<String>result, String s, int index){
        if(index == s.length()){
            results.add(result);
            return;
        }
        for(int i = index; i<s.length();i++){
            if(isPalindrome(s,index,i)){
                List<String>tmp = new ArrayList<>(result);
                tmp.add(s.substring(index,i+1));
                backTrack(tmp,s,i+1);
            }
        }return;
    }
    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
