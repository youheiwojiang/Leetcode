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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval>res = new ArrayList<>();
        if(intervals.size() == 0){//need attention
            res.add(newInterval);
            return res;
        }
        boolean addnew = false;
        for(Interval interval:intervals){
            if(interval.end < newInterval.start)
                res.add(interval);
            else if(interval.start > newInterval.end ){
                if(!addnew){
                res.add(newInterval);
                addnew = true;
                }
                res.add(interval);
            }
            else{
                 newInterval = new Interval(Math.min(interval.start,newInterval.start),Math.max(interval.end,newInterval.end));  
            }
        }
        if(!addnew) res.add(newInterval);//need attention
        return res;
    }
}


/////////////////////////////////////////////////////////////////////////
//more concise version
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval>res= new ArrayList<>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start)
            res.add(intervals.get(i++));
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval(
                Math.min(newInterval.start, intervals.get(i).start),
                Math.max(newInterval.end, intervals.get(i).end)
                );
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size()) res.add(intervals.get(i++));
        return res;
    }
}
