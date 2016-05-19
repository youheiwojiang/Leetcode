/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow  = dummy,fast = dummy;
        for(int i = 0; i< m;i++){
            slow = fast;
            fast = fast.next;
        }
        ListNode tail = slow.next;
        ListNode next = fast.next;
        for(int i = 0; i< (n -m); i++){
            fast = next;
            next= fast.next;
            fast.next= slow.next;
            slow.next = fast;
        }
        tail.next = next;
        return dummy.next;
    }
}
////better code
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre  = dummy;
        for(int i = 0; i< m-1;i++){
           pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        //key part of reversing given length linkedlist
        for(int i = 0; i< n-m;i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
