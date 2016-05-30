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
    class Point{
        int time;
        int start;
        Point(int time, int start){this.time = time;this.start = start;}
    }
    public int minMeetingRooms(Interval[] intervals) {
        Comparator<Point>comp = new Comparator<Point>(){
            public int compare(Point a, Point b){
                if(a.time == b.time) return a.start - b.start ;//a is end end = -1
                return a.time - b.time;
            }
        };
        PriorityQueue<Point>pq = new PriorityQueue<Point>(comp);
        for(Interval interval:intervals){
            pq.add(new Point(interval.start,1));
            pq.add(new Point(interval.end,-1));
        }
        int max = 0;
        int maxsofar = 0;
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            if(cur.start == 1){
                maxsofar++;
                max = Math.max(max,maxsofar);
            }else
                maxsofar--;
        
        }
        return max;
    }
}
