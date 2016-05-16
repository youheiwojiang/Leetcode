  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode cur = head;
        int len = 0;
        while(cur!=null){
            cur = cur.next;
            len++;
        }
        k = k%len;
        ListNode slow = head;cur = head;
        // this block can be improved
        for(int i = 0; i<k; i++){
            cur = cur.next;
        }while(cur.next!= null){
           slow=  slow.next;
           cur = cur.next;
        }
        //
        cur.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
