//concise re solution:
String[] parts = s.trim().split("\\s+");
String out = "";
for (int i = parts.length - 1; i > 0; i--) {
    out += parts[i] + " ";
}
return out + parts[0];
//////////////////////////////////
//my memory limit exceeded solution:
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int l = 0, r= s.length()-1;
        s = reverse(s,l,r);
        StringBuilder str=  new StringBuilder();
        for(int i = 0; i<=r;i++){
            if(s.charAt(i) == ' '){
                if(str.length()!=0) str.append(" ");
                str.append(reverse(s,l,i-1));
                i++;
                while(i<=r &&s.charAt(i) == ' ') i++;
                l = i;
            }
        }if(l <= r) str.append(" ").append(reverse(s,l,r));
       return str.toString();
    }
    private String reverse(String s ,int l, int r){
        char []arrays = new char[s.length()];
        while(l <= r){
            arrays[l] = s.charAt(r);
            arrays[r] = s.charAt(l);
            l++;r--;
        }
        return String.valueOf(arrays);
    }
}
