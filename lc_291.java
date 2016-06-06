public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Set<String>set = new HashSet<>();
        Map<Character,String>map = new HashMap<>();
        return isMatch(map,set,pattern,0,str,0);
    }
    private boolean isMatch(Map<Character,String>map,Set<String>set,String pattern, int i, String str, int j){
        if(i == pattern.length() && j == str.length()) return true;
        if(i == pattern.length() || j == str.length()) return false;
        char c = pattern.charAt(i);
        if(map.containsKey(c)){
            String next = map.get(c);
            if(!str.startsWith(next,j))
                return false;
            return isMatch(map,set,pattern,i+1,str,j+next.length());
        }else{
            for(int a = j+1;a<=str.length();a++){
                String word = str.substring(j,a);
                if(set.contains(word)) continue;
                map.put(c,word);
                set.add(word);
                if(isMatch(map,set,pattern,i+1,str,j+word.length())) return true;
                map.remove(c);
                set.remove(word);
            }
        }
        return false;
    }
}
