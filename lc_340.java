public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int slow = 0,res = 0;
        Map<Character,Integer>map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char cur = s.charAt(i);
            if(!map.containsKey(cur)) map.put(cur,0);
            map.put(cur, map.get(cur) + 1);
            while(map.size() > k){
                char tmp = s.charAt(slow);
                map.put(tmp,map.get(tmp) - 1);
                if(map.get(tmp) == 0)
                    map.remove(tmp);
                slow++;
            }
            res = Math.max(res, i - slow + 1 );
            
        }
        return res;
    }
}
