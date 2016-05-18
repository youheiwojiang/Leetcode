/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode last = dummy;
        while( cur!= null){//attention this way(directly detect if is the same node)
            while(cur.next!=null && cur.next.val == cur.val)
                cur = cur.next;
            if(last.next == cur){
                last = last.next;
            }
            else{
                last.next= cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
        
    }
}
