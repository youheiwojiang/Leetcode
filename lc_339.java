/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        //int layer = 1;
        int sum = 0;
        for(NestedInteger val:nestedList)
            sum+= getValue(val,1);
        return sum;
    }
    private int getValue(NestedInteger nest,int layer){
        if(nest.isInteger()){
            return layer * nest.getInteger();
        }
        int val = 0;
        for(NestedInteger sub: nest.getList())
            val+= getValue(sub,layer+1);
        return val;
    }
}
