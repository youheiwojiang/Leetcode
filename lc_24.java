//iterative version:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next  = head;
        if(head == null)
            return head;
        ListNode slow = fake,fast = fake,prev = fake;
        while(fast.next != null && fast.next.next != null){
            slow = fast.next.next;
            ListNode tmp = slow.next;
            fast = fast.next;
            prev.next = slow;
            slow.next = fast;
            fast.next = tmp;
            prev = fast;
        }
        return fake.next;
    }
}




//////////////////////////////////////////////////////
//recursion version:
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}

