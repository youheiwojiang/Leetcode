class MedianFinder {
     PriorityQueue<Integer> min = new PriorityQueue();
     PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size() < min.size())
            max.offer(min.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(min.size() == max.size())
            return (max.peek() + min.peek())/2.0;
        return max.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
