public class Solution {
    public int longestSubstring(String s, int k) {
        char[]ss = s.toCharArray();
        return help(ss,0,s.length(),k);
    }
    private int help(char[]ss, int start, int end , int k){
        if(end < start || end - start < k) return 0;
        int[]count = new int[26];
        for(int i = start; i < end; i++){
            count[ss[i]-'a']++;
        }
        for(int j = 0; j< 26; j++){
            if(count[j] == 0) continue;
            if(count[j] < k){
                for(int i = start ; i<end; i++){
                    if(ss[i] == j + 'a'){
                        int left = help(ss,start,i,k);
                        int right = help(ss,i+1,end,k);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end - start;
    }
}
