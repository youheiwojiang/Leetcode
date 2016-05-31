public class Solution {
    public int numWays(int n, int k) {
        if(n < 1) return 0;
        int same = 0,diff = k;
        for(int i = 0; i< n-1;i++){
            int tmp = same;
            same = diff;
            diff = tmp * (k-1) + diff* (k-1);
        }
        return same + diff;
    }
}
