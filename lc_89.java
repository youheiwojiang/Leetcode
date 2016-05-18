public class Solution {
    public List<Integer> grayCode(int n) {
        // based on n-1
        // 00 01 11 10 --> 000 001 011 010 110 111 101 100
        List<Integer>res = new ArrayList<>();
        res.add(0);
        for(int i = 0 ;i < n; i++){
            int size = res.size();
            for(int k = size-1 ; k >=0 ; k--)
                res.add(res.get(k) | 1<<i);
            
        }
        return res;
        
    }
}
