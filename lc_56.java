//it's my verison  
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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval>res = new ArrayList<>();
        if(intervals.size()==0)
            return res;
        PriorityQueue<Interval>pq = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.start == b.start)
                    return a.end - b.end;
                return a.start - b.start;
            }
        });
        for(Interval interval : intervals) pq.add(interval);
        Interval last = pq.poll();
        while(!pq.isEmpty()){
            Interval cur = pq.poll();
            if(last.end < cur.start){
                res.add(last);
                last = cur;
            }else{
                last = new Interval(last.start,Math.max(cur.end,last.end));//need attention
            }
        }res.add(last);
        return res;
        
    }
}
/////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval>res = new ArrayList<>();
        if(intervals.size() == 0)
            return res;
       Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.start == b.start)
                    return a.end - b.end;
                return a.start - b.start;
            }
        });
        Interval last = intervals.get(0);
        for(Interval interval : intervals){
            if(interval.start > last.end){
                res.add(last);
                last = interval;
            }else{
                last = new Interval(last.start, Math.max(last.end,interval.end));
            }
        }res.add(last);
        return res;
    }
}
