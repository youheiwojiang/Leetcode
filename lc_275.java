public class Solution {
    public int hIndex(int[] citations) {
        //find the first pos citations[pos] >= len-pos+1
        if(citations.length == 0||citations[citations.length-1] == 0) return 0;//keypart
        int l = 0, r = citations.length-1,mid = 0;
        while( l < r){ // this method can't get the last element 
            mid = l + (r-l)/2;
            if(citations[mid] >= citations.length - mid)
                r = mid;
            else
                l = mid + 1;
        }
        return citations.length - l;
    }
}
