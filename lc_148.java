/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode cur=null,l3 = null; // small modified
    public ListNode sortList(ListNode head) {
        //merge sort;
        if(head == null || head.next == null) return head;
        ListNode slow = head,fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        head = sortList(head);
        fast = sortList(fast);
        return merge(head,fast);
        
    }
    private ListNode merge(ListNode l1, ListNode l2){
        l3 = new ListNode(0);
        cur = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;//
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) cur.next = l1;
        else if(l2 != null) cur.next = l2;
        return l3.next;
    }
}
