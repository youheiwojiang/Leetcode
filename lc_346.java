public class MovingAverage {
    private Queue<Integer>q = new LinkedList<>();
    private int sz ;
    private int sum ;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sz = size;
        sum = 0;
    }
    
    public double next(int val) {
        if(q.size() == sz) {
            sum-= q.poll();
        }sum += val;
         q.add(val);
         return (double)sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
