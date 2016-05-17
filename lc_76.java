public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() ==0 || t.length() == 0 ||s.length() < t.length())
            return "";
        Map<Character,Integer>map = new HashMap<>();
        for(char a: t.toCharArray()){
            if(!map.containsKey(a))
                map.put(a,0);
            map.put(a,map.get(a)+1);
        }
        int min = s.length(),l = 0,r = 0,count = t.length();
        int minl=0,minr=0;
        while(r < s.length()){
            while(r< s.length() && count > 0){ //move right pointer until get a satisfying answer
                if(map.containsKey(s.charAt(r))){
                    if(map.get(s.charAt(r))> 0) count--;
                    map.put(s.charAt(r),map.get(s.charAt(r)) - 1);
                }
                r++;
            }
            while(count == 0 && l < r){ // move left pointer until a not satisfying answer
                if(!map.containsKey(s.charAt(l)) || map.get(s.charAt(l)) < 0){
                    if(map.containsKey(s.charAt(l)))
                        map.put(s.charAt(l),map.get(s.charAt(l))+1);
                   
                }
                else{
                count++;
                map.put(s.charAt(l),map.get(s.charAt(l))+1);
                }
                l++;
            }
            if(r - l+1  <= min) {min = r- l+1;minl = l-1;minr = r;}; // note the l and r pointer
        }
        return s.substring(minl,minr);
        
    }
}
