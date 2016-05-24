public class Solution { // another sliding window(consider this method when find a longest or max in a string)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 2) return s.length();
        Map<Character,Integer>map = new HashMap<>();
        int l = 0, r = 0;
        int len = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
                if(map.size() > 2){
                    len = Math.max(r-l,len);
                    while(map.size() > 2){
                        char tmp = s.charAt(l);
                        map.put(tmp,map.get(tmp)-1);
                        if(map.get(tmp) == 0){
                            map.remove(tmp);
                        }
                        l++;
                    }
                }                
            }r++;
        }
        return Math.max(len, s.length() - l);
    }
}
