public class Solution {
    public boolean isHappy(int n) {
        int slow = n,fast = nextNum(n);
        while(slow != 1 && fast != 1 && fast!=slow ){
            fast = nextNum(nextNum(fast));
            slow = nextNum(slow);
        }
        if(slow == 1 || fast == 1) return true;
        return false;
        
    }
    private int nextNum(int n){
        int res = 0;
        while(n != 0){
            int tmp = n%10;
            res += tmp*tmp;
            n /= 10;
        }
        return res;
    }
}
