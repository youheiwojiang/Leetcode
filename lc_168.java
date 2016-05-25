//consider 1 base or 0 base divider
//a consice code:
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}

////////////////////////////////////////////////////
//my code:
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();
        while(n != 0){
            int val = n%26; // can't handle n%26 == 0;
            if(val == 0){
                str.append("Z");
                n = n/26 -1;
            }
            else{
                str.append((char)('A' + val -1));
                n /= 26;
            }
        }
        return str.reverse().toString();
    }
}
