public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int carry = 0;
        int ia = a.length()-1,ib = b.length()-1;
        while(ia >= 0 || ib >=0 || carry ==1){
            int cur = carry + (ia >=0?(a.charAt(ia--) -'0'):0)+(ib >=0 ?(b.charAt(ib--) -'0'):0);//need attention put parenthese!!
            carry = cur>=2?1:0;
            str.append(cur%2);
        }
        return str.reverse().toString();
    }
}
