public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder str = new StringBuilder();
        str.append((numerator>0) ^ (denominator>0)?"-":"");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        str.append(num/den);
        num %= den;
        if(num == 0) return str.toString();
        str.append(".");
        Map<Long,Integer>map = new HashMap<>();
        map.put(num,str.length());
        while(num != 0){
            num*= 10;
            str.append(num/den);
            num %= den;
            if(map.containsKey(num)){
                int index = map.get(num);
                str.insert(index,"(");
                str.append(")");
                num =0 ;
            }
            else map.put(num,str.length());
        }
        return str.toString();
    }
}
