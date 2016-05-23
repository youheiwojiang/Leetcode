/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    Map<Integer,RandomListNode>map = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head == null) return null;
        if(map.containsKey(head.label)) return map.get(head.label);
        RandomListNode clone = new RandomListNode(head.label);
        map.put(clone.label,clone); //key part
        clone.next = copyRandomList(head.next);
        clone.random = copyRandomList(head.random);
        return clone;
    }
}
