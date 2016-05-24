//great code:
//
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)    return 0;
        if(points.length < 2) return points.length;
        int result = 0;
        for(int i = 0; i< points.length;i++){
             Map<Double,Integer>map = new HashMap<>();
             int samex = 1;
             int samep = 0;
             for(int j = 0; j<points.length;j++){
                 if(i!=j){
                     if(points[i].x == points[j].x && points[i].y == points[j].y)
                        samep++;
                     if(points[i].x == points[j].x){
                         samex++;
                         continue;
                     }
                     double k = (double)(points[i].y -points[j].y)/(double)(points[i].x - points[j].x);
                     if(map.containsKey(k)){
                         map.put(k,map.get(k)+1);
                     }else map.put(k,2);
                     result = Math.max(result,map.get(k) + samep);
                 }
             }result = Math.max(result,samex);
        }
        return result;
    }
}
