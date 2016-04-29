public class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        int l = 1,r = x,mid = 0;
        while(true){
            mid = l + (r - l)/2;
            if(mid > x/mid)
                r = mid -1;
            else{
                if(mid+1 > x/(mid+1))// here needs to be careful
                // it means sqrt < mid + 1
                    return mid;
                else
                    l = mid + 1;
            }
        }
    }
}
