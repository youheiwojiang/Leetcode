/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        PriorityQueue<ListNode>pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){ return a.val -b.val;}
        });
        while(head!=null){
            pq.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        head = dummy;
        while(!pq.isEmpty()){
            head.next = pq.poll();
            head = head.next;
        }
        head.next  = null;
        return dummy.next;
    }
}
