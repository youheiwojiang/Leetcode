/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval>comp = new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.start == b.start) return a.end -b.end;   
                return a.start-b.start;
            }
        };//key part
        Arrays.sort(intervals,comp);
        int prev = 0;
        for(Interval interval:intervals){
            if(interval.start < prev) return false;
            else prev = interval.end;
        }
        return true;
    }
}
