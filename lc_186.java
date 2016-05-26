public class Solution {
    public void reverseWords(char[] s) {
        reverseAword(s,0,s.length-1);
        int prev = 0;
        for(int i = 0; i< s.length;i++){
            if(s[i] == ' '){
                reverseAword(s,prev,i-1);
                prev = i+1;
            }
        }
        if(prev < s.length);
        reverseAword(s,prev,s.length-1);
        return;
    }
    private void reverseAword(char[]s,int l,int r){
        while(l<r){
            char tmp = s[l];
            s[l]= s[r];
            s[r] = tmp;
            l++;r--;
        }
        return;
    }
}
