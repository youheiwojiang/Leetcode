/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode fast = head,slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode precur = slow.next;
        ListNode mid = slow;
        while(precur.next !=null){ // tricky ways to reverse
            ListNode cur = precur.next;
            precur.next = cur.next;
            cur.next =mid.next;
            mid.next = cur;
        }
         slow = head;
        fast = mid.next;
        while(slow != mid){
            mid.next = fast.next;
            fast.next =slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = mid.next;
        }
        return;
    }
}
