/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head,slow = head;
        while(fast.next!= null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode precur = slow.next;
        // typical way to reverse second half of a Linkedlist
       while(precur.next != null){
            ListNode cur = precur.next;
            precur.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
           
        }
        precur = slow.next;
        while(precur!=null){
            if(head.val != precur.val) return false;
            head = head.next;
            precur = precur.next;
        }
        return true;
    }
}
