/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;//only handle the positive input
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null){
            ListNode tmp = head.next;
            cur = dummy;
            while(cur.next != null && cur.next.val < head.val)
                cur = cur.next;
            head.next = cur.next;
            cur.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}
