/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode precur = head;
        while(precur.next != null){
            ListNode cur = precur.next;
            precur.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        precur = dummy.next;
        while(precur != null){
            if(precur.val != 9) {
                precur.val = precur.val + 1;
                break;
            }else{
                precur.val = 0;
                if(precur.next == null){
                    precur.next = new ListNode(1);
                    break;
                }
                precur = precur.next;
            }
        }
        precur = dummy.next;
        while(precur.next != null){
            ListNode cur = precur.next;
            precur.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }
}
