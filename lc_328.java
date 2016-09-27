/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode p1 = odd,p2 = even;
        ListNode cur = head;
        while(cur != null && cur.next != null){
                p1.next = cur;
                p1 = p1.next;
                cur = cur.next;
                p1.next = null;
                p2.next = cur;
                p2 = p2.next;
                cur = cur.next;
                p2.next = null;
        }
        if(cur != null){
            p1.next = cur;
            p1 = p1.next;
        }
        p1.next = even.next;
        return odd.next;
        
    }
}
