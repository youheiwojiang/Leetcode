  public class Solution {
    public String multiply(String num1, String num2) {
        // this will overflow
        /*
        long res = 0;
        for(int i = 0; i< num1.length();i++){
            long tmp =0;
            for(int j =0 ; j< num2.length(); j++){
                tmp = 10 * tmp + (num1.charAt(i)-'0')*(num2.charAt(j) - '0');
            }
            res = 10*res + tmp;
        }
        return Long.toString(res);
        */
        int project[]= new int[num1.length() + num2.length()];
        for(int i = num1.length()-1; i>=0;i--){
            for(int j =num2.length()-1 ;j>=0; j--){
                project[i + j + 1] += (num1.charAt(i)-'0')*(num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for(int i = project.length-1; i>=0; i--){
            int tmp = project[i]+carry;
            carry = tmp/10;
            project[i] =  tmp%10;
        }
        StringBuilder str= new StringBuilder();
        for(int i:project){
            str.append(i);
        }
        while(str.length() != 0 && str.charAt(0) == '0') str.deleteCharAt(0);//need attention
        return str.length() == 0?"0":str.toString();
    }
}
