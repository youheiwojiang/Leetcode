//two stack code:
public class MinStack {
    private Stack<Integer>value;
    private Stack<Integer>min;
    /** initialize your data structure here. */
    public MinStack() {
        value = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        value.push(x);
        if(!min.isEmpty() && x >= min.peek()) 
            min.push(min.peek()); //key
        else
            min.push(x);
    }
    
    public void pop() {
        value.pop();
        min.pop();
    }
    
    public int top() {
        return value.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
/////////////////////////////////////////////////////////
//one stack code:
public class MinStack {
    private long min = 0;//key
    private Stack<Long>stack = new Stack<Long>();//key
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            min = x;
            stack.push(0L);//attention
        }else{
            stack.push(x - min);
            if(x < min){
                min = x;
            }
        }
    }
    
    public void pop() {
        long tmp = stack.pop();
        if(tmp < 0)
            min = min -tmp;
    }
    
    public int top() {
        if(stack.peek() < 0) return (int)min;
        else return (int)(min+stack.peek());
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
